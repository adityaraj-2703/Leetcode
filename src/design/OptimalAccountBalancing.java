package design;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class OptimalAccountBalancing {
    public int minTransfers(int[][] transactions) {
        Map<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < transactions.length; i++) {
            int from = transactions[i][0];
            int to = transactions[i][1];
            int amount = transactions[i][2];
            hm.put(from, hm.getOrDefault(from, 0) - amount);
            hm.put(to, hm.getOrDefault(to, 0) + amount);
        }
        Queue<Map.Entry<Integer, Integer>> min = new PriorityQueue<>(new Comparator<Map.Entry<Integer, Integer>>() {
            public int compare(Map.Entry<Integer, Integer> m1, Map.Entry<Integer, Integer> m2) {
                return m1.getValue() - m2.getValue();
            }
        });
        Queue<Map.Entry<Integer, Integer>> max = new PriorityQueue<>(new Comparator<Map.Entry<Integer, Integer>>() {
            public int compare(Map.Entry<Integer, Integer> m1, Map.Entry<Integer, Integer> m2) {
                return m2.getValue() - m1.getValue();
            }
        });
        for (Map.Entry<Integer, Integer> m : hm.entrySet()) {
            if (m.getValue() < 0) {
                min.add(m);
            } else if (m.getValue() > 0) {
                max.add(m);
            }
        }
        int count = 0;
        while (!min.isEmpty() && !max.isEmpty()) {

            Map.Entry<Integer, Integer> m1 = min.poll();
            Map.Entry<Integer, Integer> m2 = max.poll();
            count++;
            int val = m2.getValue() + m1.getValue();
            if (val < 0) {
                m1.setValue(val);
                min.add(m1);

            } else if (val > 0) {
                m2.setValue(val);
                max.add(m2);

            }

        }

        return count;

    }

    public static void main(String[] args) {
        OptimalAccountBalancing o = new OptimalAccountBalancing();
        int[][] transactions = { { 0, 1, 2 }, { 1, 2, 1 }, { 1, 3, 1 } };
        System.out.println(o.minTransfers(transactions));
    }

}

package hash;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class BetterCompression {
    public String betterCompression(String compressed) {
        StringBuilder sb = new StringBuilder();
        Map<Character, Pair> hm = new HashMap<>();
        int ind = 0;
        int i = 0;
        while (i < compressed.length()) {
            char c = compressed.charAt(i);
            int temp = 0;
            while (i + 1 < compressed.length() && compressed.charAt(i + 1) >= '0' && compressed.charAt(i + 1) <= '9') {
                temp = temp * 10 + compressed.charAt(i + 1) - '0';
                i++;
            }
            if (hm.containsKey(c)) {
                hm.put(c, new Pair(hm.get(c).count + temp, ind));
                ind++;
            } else {
                hm.put(c, new Pair(temp, ind));
                ind++;
            }
            i++;

        }
        Queue<Map.Entry<Character, Pair>> q = new PriorityQueue<>(new Comparator<Map.Entry<Character, Pair>>() {
            public int compare(Map.Entry<Character, Pair> m1, Map.Entry<Character, Pair> m2) {
                return m1.getValue().ind - m2.getValue().ind;
            }
        });
        for (Map.Entry<Character, Pair> m : hm.entrySet()) {
            q.add(m);
        }
        while (!q.isEmpty()) {
            Map.Entry<Character, Pair> m = q.poll();
            sb.append(m.getKey());
            sb.append(m.getValue().count);
        }
        return sb.toString();

    }

    class Pair {
        int count;
        int ind;

        Pair(int count, int ind) {
            this.count = count;
            this.ind = ind;
        }
    }

    public static void main(String[] args) {
        BetterCompression b = new BetterCompression();
        System.out.println(b.betterCompression("a12c56a1b5"));
    }

}

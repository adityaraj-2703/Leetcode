package heap;

import java.util.PriorityQueue;

public class PutMarblesInABag {
    public long putMarbles(int[] weights, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((n1, n2) -> n1 - n2);
        for (int i = 1; i < weights.length; i++) {
            pq.add(weights[i] + weights[i - 1]);
        }
        int count = 0;
        int min = 0;
        while (!pq.isEmpty() && count < k - 1) {
            min += pq.poll();
            count++;
        }

        pq = new PriorityQueue<>((n1, n2) -> n2 - n1);
        for (int i = 1; i < weights.length; i++) {
            pq.add(weights[i] + weights[i - 1]);
        }
        count = 0;
        int max = 0;
        while (!pq.isEmpty() && count < k - 1) {
            max += pq.poll();
            count++;
        }
        return max - min;

    }

    public static void main(String[] args) {
        PutMarblesInABag p = new PutMarblesInABag();
        int[] weights = { 1, 3, 5, 1 };
        int k = 2;
        System.out.println(p.putMarbles(weights, k));
    }

}

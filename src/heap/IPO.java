package heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class IPO {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int[][] disk = new int[profits.length][2];
        for (int i = 0; i < profits.length; i++) {
            disk[i][0] = profits[i];
            disk[i][1] = capital[i];

        }
        Arrays.sort(disk, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[1] - b[1];
            }
        });
        PriorityQueue<Integer> pq = new PriorityQueue<>((n1, n2) -> n2 - n1);
        int ind = 0;
        while (ind < profits.length && disk[ind][1] <= w) {
            pq.add(disk[ind][0]);
            ind++;
        }
        while (!pq.isEmpty() && k > 0) {
            int temp = pq.poll();
            w += temp;
            while (ind < profits.length && disk[ind][1] <= w) {
                pq.add(disk[ind][0]);
                ind++;
            }
            k--;

        }
        return w;
    }

    public static void main(String[] args) {
        IPO ipo = new IPO();
        int k = 2;
        int w = 0;
        int[] profits = { 1, 2, 3 };
        int[] capital = { 0, 1, 1 };
        System.out.println(ipo.findMaximizedCapital(k, w, profits, capital));
    }

}

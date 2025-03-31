package heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MaximumSubsequenceScore {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        int[][] d = new int[nums1.length][2];
        for (int i = 0; i < nums1.length; i++) {
            d[i][0] = nums1[i];
            d[i][1] = nums2[i];

        }
        Arrays.sort(d, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[1] * a[0] - b[1] * b[0];
            }
        });
        PriorityQueue<int[]> pq = new PriorityQueue<>((n1, n2) -> n1[1] * n1[0] - n2[1] * n2[0]);
        int sum = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < k; i++) {
            int[] temp = new int[2];
            sum += d[i][0];
            min = Math.min(min, d[i][1]);
            pq.add(new int[] { d[i][0], d[i][1] });
        }
        long max = sum * min;
        while (k < d.length) {
            int[] temp = pq.poll();
            sum -= temp[0];
            sum += d[k][0];
            pq.add(new int[] { d[k][0], d[k][1] });

            max = Math.max(max, sum * min);
            k++;
        }

        return max;
    }

    public static void main(String[] args) {
        int[] nums1 = { 2, 1, 14, 12 };
        int[] nums2 = { 11, 7, 13, 6 };
        int k = 3;
        MaximumSubsequenceScore m = new MaximumSubsequenceScore();
        System.out.println(m.maxScore(nums1, nums2, k));
    }

}

package heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Kthclosestpointtoorigin {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                int sum1 = a[0] * a[0] + a[1] * a[1];
                int sum2 = b[0] * b[0] + b[1] * b[1];
                return sum2 - sum1;
            }
        });
        Arrays.sort(points, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                int sum1 = a[0] * a[0] + a[1] * a[1];
                int sum2 = b[0] * b[0] + b[1] * b[1];
                return sum2 - sum1;
            }
        });
        int i = 1;
        int count = 1;
        // while (i < points.length) {
        // if (count == k) {
        // break;
        // }
        // if ((points[i][0] * points[i][0] + points[i][1] * points[i][1]) > (points[i -
        // 1][0] * points[i - 1][0]
        // + points[i - 1][1] * points[i - 1][1])) {
        // count++;
        // i++;
        // }
        // }
        int[][] ans = new int[points.length - count][2];
        int ind = 0;
        for (int j = points.length - 1; j > points.length - k - 1; j--) {
            ans[ind] = points[j];
            ind++;
        }
        return ans;

    }

    public static void main(String[] args) {
        Kthclosestpointtoorigin k = new Kthclosestpointtoorigin();
        int[][] points = { { 3, 3 }, { 5, -1 }, { -2, 4 } };
        int k1 = 2;
        int[][] ans = k.kClosest(points, k1);
        for (int i = 0; i < ans.length; i++) {
            System.out.println(ans[i][0] + " " + ans[i][1]);
        }
    }

}

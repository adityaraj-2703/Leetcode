package hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Merge2DArray {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        List<Pair> p = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i][0] == nums2[j][0]) {
                p.add(new Pair(nums1[i][0], nums1[i][1] + nums2[i][1]));
                i++;
                j++;
            } else if (nums1[i][0] < nums2[i][0]) {
                p.add(new Pair(nums1[i][0], nums1[i][1]));
                i++;
            } else {
                p.add(new Pair(nums2[j][0], nums2[j][1]));
                j++;
            }
        }
        while (i < nums1.length) {
            p.add(new Pair(nums1[i][0], nums1[i][1]));
            i++;
        }
        while (j < nums2.length) {
            p.add(new Pair(nums2[i][0], nums2[i][1]));
            j++;
        }

        int[][] ans = new int[p.size()][2];
        for (int k = 0; k < ans.length; k++) {
            ans[k][0] = p.get(k).a;
            ans[k][1] = p.get(k).b;
        }
        return ans;
    }

    class Pair {
        int a;
        int b;

        Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }

    public static void main(String[] args) {
        int[][] arr1 = { { 1, 2 }, { 2, 3 }, { 4, 5 } };
        int[][] arr2 = { { 1, 4 }, { 3, 2 }, { 4, 1 } };
        Merge2DArray m = new Merge2DArray();
        int[][] ans = m.mergeArrays(arr1, arr2);
        for (int i = 0; i < ans.length; i++) {
            System.out.println(ans[i][0] + ":" + ans[i][1]);
            System.out.println();
        }

    }

}

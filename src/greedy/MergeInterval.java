package greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeInterval {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                if (a[1] == b[1]) {
                    return a[0] - b[0];
                }
                return a[1] - b[1];
            }
        });
        List<int[]> al = new ArrayList<>();
        int i = 1;
        al.add(intervals[0]);
        int ind = 1;
        while (i < intervals.length) {
            int[] temp = al.get(ind - 1);
            if (temp[1] >= intervals[i][0]) {
                temp[1] = Math.max(temp[1], intervals[i][1]);
            } else {
                al.add(intervals[i]);
                ind++;
            }
            i++;

        }
        int[][] array = new int[al.size()][];
        for (int j = 0; j < al.size(); j++) {
            array[j] = al.get(j);
        }
        return array;
    }

    public static void main(String[] args) {
        int[][] intervals = { { 1, 3 }, { 2, 6 }, { 8, 10 }, { 15, 18 } };
        MergeInterval m = new MergeInterval();
        int[][] res = m.merge(intervals);
        for (int j = 0; j < res.length; j++) {
            System.out.println(res[j][0] + " " + res[j][1]);
        }
    }

}

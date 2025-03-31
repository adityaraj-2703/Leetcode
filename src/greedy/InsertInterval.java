package greedy;

import java.util.ArrayList;
import java.util.List;

public class InsertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int i = 0;
        List<int[]> res = new ArrayList<>();
        while (i < intervals.length && intervals[i][1] < newInterval[0]) {
            res.add(intervals[i]);
            i++;
        }
        int st = newInterval[0];
        int en = newInterval[1];

        while (i < intervals.length && intervals[i][0] <= newInterval[1]) {
            int min = Math.min(st, intervals[i][0]);
            int max = Math.max(en, intervals[i][1]);
            st = min;
            en = max;
            newInterval = new int[] { min, max };
            i++;
        }
        res.add(newInterval);
        while (i < intervals.length) {
            res.add(intervals[i]);
            i++;
        }
        int[][] array = new int[res.size()][];
        for (int j = 0; j < res.size(); j++) {
            array[j] = res.get(j);
        }
        return array;

    }

    public static void main(String[] args) {
        int[][] intervals = { { 1, 2 }, { 3, 5 }, { 6, 7 }, { 8, 10 }, { 12, 16 } };
        int[] newInterval = { 4, 8 };
        InsertInterval i = new InsertInterval();
        int[][] res = i.insert(intervals, newInterval);
        for (int j = 0; j < res.length; j++) {
            System.out.println(res[j][0] + " " + res[j][1]);
        }
    }

}

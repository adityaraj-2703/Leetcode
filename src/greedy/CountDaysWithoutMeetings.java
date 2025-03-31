package greedy;

import java.util.Arrays;
import java.util.Comparator;

public class CountDaysWithoutMeetings {
    public int countDays(int days, int[][] meetings) {
        Arrays.sort(meetings, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[1] - b[1];

            }
        });
        int i = 1;
        int ind = 0;
        int count = 0;
        while (i < days && ind < meetings.length) {
            if (meetings[ind][0] > i) {
                count += meetings[ind][0] - i;
            }
            i = meetings[ind][1] + 1;
            ind++;
        }
        return count;
    }

    public static void main(String[] args) {
        CountDaysWithoutMeetings c = new CountDaysWithoutMeetings();
        int[][] meetings = { { 5, 7 }, { 1, 3 }, { 9, 10 } };
        System.out.println(c.countDays(10, meetings));
    }

}

package dp;

import java.util.HashSet;
import java.util.Set;

public class CountNumberOfPowerfulIntegers {
    public long numberOfPowerfulInt(long start, long finish, int limit, String s) {
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) - '0' > limit) {
                return 0;
            }
        }
        long str = Long.parseLong(s);
        int count = 0;
        if (str >= start && str <= finish) {
            count++;
        }
        Set<Long> hs = new HashSet<>();
        count += numberOfPowerfulIntUtil(start, finish, limit, s, str, hs);
        return count;
    }

    public int numberOfPowerfulIntUtil(long start, long finish, int limit, String s, long str, Set<Long> hs) {
        if (str > finish) {
            return 0;
        }

        long h = (long) Math.pow(10, s.length());
        int sum = 0;
        // String s2 =

        for (int i = 0; i <= limit; i++) {

            long val = h * i + str;
            String s1 = i + "" + s;
            if (val >= start && val <= finish) {
                System.out.println("val: " + val);
                sum++;
                sum += numberOfPowerfulIntUtil(start, finish, limit, s1, val, hs);
                sum += numberOfPowerfulIntUtil(start, finish, limit, s1, str, hs);
            } else {
                break;
            }
        }
        return sum;

    }

    public static void main(String[] args) {
        CountNumberOfPowerfulIntegers obj = new CountNumberOfPowerfulIntegers();
        System.out.println(obj.numberOfPowerfulInt(20, 1159, 5, "20"));

    }

}

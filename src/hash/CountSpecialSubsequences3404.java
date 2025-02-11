package hash;

import java.util.HashMap;
import java.util.Map;

public class CountSpecialSubsequences3404 {
    public long numberOfSubsequences(int[] nums) {
        Map<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (Math.abs(j - i) <= 1) {
                    continue;
                }
                int gcd = gcd(nums[i], nums[j]);
                int num = nums[i] / gcd;
                int den = nums[j] / gcd;
                int temp = num * 1000 + den;

                hm.put(temp, hm.getOrDefault(temp, 0) + 1);
            }
        }
        long sum = 0;
        for (Map.Entry<Integer, Integer> m : hm.entrySet()) {
            int val = m.getValue();
            sum += val / 6;
        }
        return sum;

    }

    class Pair {
        int num;
        int den;

        Pair(int num, int den) {
            this.num = num;
            this.den = den;
        }

        public int hashCode() {
            return num * 1000 + den;
        }
    }

    public int gcd(int a, int b) {
        if (a % b == 0) {
            return b;
        }
        if (b > a) {
            return gcd(b, a);
        }
        int temp = a % b;
        return gcd(b, temp);
    }

    public static void main(String[] args) {
        CountSpecialSubsequences3404 c = new CountSpecialSubsequences3404();
        int[] nums = { 1, 2, 3, 4, 3, 6, 1 };
        System.out.println(c.numberOfSubsequences(nums));
    }

}

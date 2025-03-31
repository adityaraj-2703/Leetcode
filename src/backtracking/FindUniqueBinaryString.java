package backtracking;

import java.util.HashSet;
import java.util.Set;

public class FindUniqueBinaryString {
    public String findDifferentBinaryString(String[] nums) {
        int len = nums[0].length();
        int min = (int) Math.pow(2, len - 1);
        int max = (int) Math.pow(2, len) - 1;
        Set<Integer> hs = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            int f = find(nums[i]);
            hs.add(f);
        }
        for (int i = max; i >= 0; i--) {
            if (!hs.contains(i)) {
                return findS(i);
            }
        }
        return null;
        // StringBuilder sb = new StringBuilder();
        // return findDifferentBinaryStringUtil(hs,len,sb);
    }

    public String findS(int s) {
        if (s == 0) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        int ind = 0;
        while (s > 0) {
            sb.append(s % 2);
            s = s / 2;
        }
        return sb.reverse().toString();
    }

    public int find(String s) {
        int n = 0;
        int ind = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            n += (int) Math.pow(2, ind) * (s.charAt(i) - '0');
            ind++;
        }
        return n;
    }

    public String findDifferentBinaryStringUtil(Set<String> hs, int len, StringBuilder sb) {
        if (sb.length() == len) {
            if (!hs.contains(sb.toString())) {
                return sb.toString();
            } else {
                return null;
            }
        }
        for (int i = 0; i <= 1; i++) {
            sb.append(i);
            if (findDifferentBinaryStringUtil(hs, len, sb) != null) {
                return sb.toString();
            }
            sb.deleteCharAt(sb.length() - 1);
        }
        return null;
    }

    public static void main(String[] args) {
        FindUniqueBinaryString f = new FindUniqueBinaryString();
        String[] nums = { "1" };
        System.out.println(f.findDifferentBinaryString(nums));
    }

}

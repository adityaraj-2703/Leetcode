package slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        Map<Character, Integer> f1 = new HashMap<>();
        Map<Character, Integer> f2 = new HashMap<>();
        if (t.length() > s.length()) {
            return "";
        }

        for (int i = 0; i < t.length(); i++) {
            f1.put(t.charAt(i), f1.getOrDefault(t.charAt(i), 0) + 1);

        }
        int i = 0;
        int j = 0;

        int start = -1;
        int end = -1;
        int min = Integer.MAX_VALUE;
        while (j < s.length()) {
            if (!check(f1, f2)) {

            } else {
                if (min > j - i + 1) {
                    min = j - i + 1;
                    start = i;
                    end = j;
                }
                while (check(f1, f2)) {
                    int l = f2.get(s.charAt(i));
                    if (l == 1) {
                        f2.remove(s.charAt(i));
                    } else {
                        f2.put(s.charAt(i), l - 1);
                    }
                    i++;

                }
            }
            f2.put(s.charAt(j), f2.getOrDefault(s.charAt(i), 0) + 1);

            j++;

        }
        while (check(f1, f2)) {
            int l = f2.get(s.charAt(i));
            if (l == 1) {
                f2.remove(s.charAt(i));
            } else {
                f2.put(s.charAt(i), l - 1);
            }
            i++;

        }
        if (start == -1) {
            return "";
        }
        return s.substring(i - 1, j);
    }

    public boolean check(Map<Character, Integer> f1, Map<Character, Integer> f2) {
        for (Map.Entry<Character, Integer> m : f1.entrySet()) {
            if (!f2.containsKey(m.getKey()) || f2.get(m.getKey()) < m.getValue()) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        MinimumWindowSubstring m = new MinimumWindowSubstring();
        System.out.println(m.minWindow(s, t));
    }

}

package hash;

import java.util.HashMap;
import java.util.Map;

public class PermutationInAString {
    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> hm = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            hm.put(s1.charAt(i), hm.getOrDefault(s1.charAt(i), 0) + 1);
        }
        int i = 0;
        int j = 0;
        while (j < s2.length()) {
            if (hm.containsKey(s2.charAt(j))) {
                Map<Character, Integer> hm1 = new HashMap<>();
                while (j < s2.length() && hm.containsKey(s2.charAt(j))) {
                    hm1.put(s2.charAt(j), hm1.getOrDefault(s2.charAt(j), 0) + 1);
                    j++;
                }
                if (check(hm1, hm)) {
                    return true;
                } else {
                    j++;

                }
            } else {
                j++;

            }

        }
        return false;
    }

    public boolean check(Map<Character, Integer> m1, Map<Character, Integer> m2) {
        if (m1.size() != m2.size()) {
            return false;
        }
        for (Map.Entry<Character, Integer> m : m1.entrySet()) {
            if (m2.containsKey(m.getKey())) {
                if (m2.get(m.getKey()) != m.getValue()) {
                    return false;
                }
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        PermutationInAString p = new PermutationInAString();
        System.out.println(p.checkInclusion("ab", "eidboaoo"));
    }

}

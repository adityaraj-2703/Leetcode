package hash;

import java.util.HashMap;
import java.util.Map;

public class FinkKLengthSubstringWithNoRepeatedChars {
    public int numKLenSubstrNoRepeats(String s, int k) {
        Map<Character, Integer> hm = new HashMap<>();
        int l = 0;
        int r = 0;
        int count = 0;
        while (r < s.length()) {
            if (hm.containsKey(s.charAt(r))) {
                hm.clear();
                hm.put(s.charAt(r), r);
                l = r;
            } else {
                hm.put(s.charAt(r), r);
                int len = r - l + 1;
                if (len == k) {
                    count++;
                    hm.remove(s.charAt(l));
                    l++;
                }

            }
            r++;
        }
        if (r - l == k) {
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        FinkKLengthSubstringWithNoRepeatedChars f = new FinkKLengthSubstringWithNoRepeatedChars();
        System.out.println(f.numKLenSubstrNoRepeats("havefunonleetcode", 5));
    }

}

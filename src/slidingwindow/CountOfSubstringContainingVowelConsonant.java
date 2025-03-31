package slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class CountOfSubstringContainingVowelConsonant {
    public long countOfSubstrings(String word, int k) {
        Map<Character, Integer> hm = new HashMap<>();
        int cv = 0;
        int cc = 0;
        int i = 0;
        int j = 0;
        int count = 0;
        while (j < 5 + k) {
            if (word.charAt(j) == 'a' || word.charAt(j) == 'e' || word.charAt(j) == 'i' || word.charAt(j) == 'o'
                    || word.charAt(j) == 'u') {
                hm.put(word.charAt(j), hm.getOrDefault(word.charAt(j), 0) + 1);
            } else {
                cc++;
            }
            j++;
        }
        if (hm.size() == 5 && cc == k) {
            count++;
        }
        while (j < word.length()) {
            int l = hm.getOrDefault(word.charAt(i), -1);
            if (l == -1) {
                cc--;
            } else if (l == 1) {
                hm.remove(word.charAt(i));
            } else {
                hm.put(word.charAt(i), l - 1);
            }

            if (word.charAt(j) == 'a' || word.charAt(j) == 'e' || word.charAt(j) == 'i' || word.charAt(j) == 'o'
                    || word.charAt(j) == 'u') {
                hm.put(word.charAt(j), hm.getOrDefault(word.charAt(j), 0) + 1);
            } else {
                cc++;
            }
            if (hm.size() == 5 && cc == k) {
                count++;
            }
            i++;
            j++;

        }
        return count;
    }

    public static void main(String[] args) {
        String s = "ieaouqqieaouqq";
        int k = 1;
        CountOfSubstringContainingVowelConsonant c = new CountOfSubstringContainingVowelConsonant();
        System.out.println(c.countOfSubstrings(s, k));
    }

}

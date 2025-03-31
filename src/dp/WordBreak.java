package dp;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> hs = new HashSet<>();
        for (int i = 0; i < wordDict.size(); i++) {
            hs.add(wordDict.get(i));
        }
        return wordBreakUtil(s, hs, 0);
    }

    public boolean wordBreakUtil(String s, Set<String> hs, int i) {
        if (i >= s.length()) {
            return true;
        }
        boolean ans = false;
        for (int k = i; k <= s.length(); k++) {
            if (hs.contains(s.substring(i, k))) {
                ans = wordBreakUtil(s, hs, k);
                if (ans) {
                    break;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "aaaaaaa";
        List<String> wordDict = Arrays.asList("aaaa", "aaa");
        WordBreak w = new WordBreak();
        System.out.println(w.wordBreak(s, wordDict));
    }

}

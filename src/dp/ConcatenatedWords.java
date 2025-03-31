package dp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConcatenatedWords {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        Map<String, Integer> hm = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            hm.put(words[i], i);
        }
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            if (wordBreak(words[i], hm, i)) {
                ans.add(words[i]);
            }
        }
        return ans;
    }

    public boolean wordBreak(String word, Map<String, Integer> hm, int ind) {
        boolean[] dp = new boolean[word.length() + 1];
        // dp[word.length()] = true;
        dp[0] = true;
        for (int i = 1; i <= word.length(); i++) {
            for (int j = (i == word.length() ? 1 : 0); !dp[i] && j < i; j++) {
                System.out.println(word.substring(j, i));
                dp[i] = dp[j] && hm.containsKey(word.substring(j, i)) && hm.get(word.substring(j, i)) != ind;
            }
        }
        return dp[word.length()];
    }

    public static void main(String[] args) {
        ConcatenatedWords c = new ConcatenatedWords();
        String[] words = { "cat", "cats", "catsdogcats", "dog", "dogcatsdog", "hippopotamuses", "rat", "ratcatdogcat" };
        System.out.println(c.findAllConcatenatedWordsInADict(words));
    }

}

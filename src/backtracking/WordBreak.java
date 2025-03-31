package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<List<String>> al = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        Set<String> hs = new HashSet<>();
        for (int i = 0; i < wordDict.size(); i++) {
            hs.add(wordDict.get(i));
        }
        wordBreakUtil(s, hs, al, temp, 0);
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < al.size(); i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < al.get(i).size(); j++) {
                sb.append(al.get(i).get(j));
                sb.append(' ');
            }
            sb.deleteCharAt(sb.length() - 1);
            ans.add(sb.toString());
        }
        return ans;

    }

    public void wordBreakUtil(String s, Set<String> hs, List<List<String>> al, List<String> temp, int i) {
        if (i >= s.length()) {
            al.add(new ArrayList<>(temp));

        }
        for (int k = i; k <= s.length(); k++) {
            if (hs.contains(s.substring(i, k))) {
                temp.add(s.substring(i, k));
                wordBreakUtil(s, hs, al, temp, k);
                temp.remove(temp.size() - 1);
            }

        }
    }

    public static void main(String[] args) {
        String s = "catsanddog";
        List<String> worDict = Arrays.asList("cat", "cats", "and", "sand", "dog");
        WordBreak w = new WordBreak();
        System.out.println(w.wordBreak(s, worDict));

    }

}

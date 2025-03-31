package trie;

import java.util.ArrayList;
import java.util.List;

class SearchSuggestion {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Trie t = new Trie();
        for (int i = 0; i < products.length; i++) {
            t.addWord(t, products[i]);
        }
        List<List<String>> ans = new ArrayList<>();
        for (int i = 0; i < searchWord.length(); i++) {
            List<String> li = t.findWords(t, searchWord.substring(0, i + 1));
            ans.add(li);
        }

        return ans;

    }

    class Trie {
        Trie[] children;
        boolean isEnd;

        Trie() {
            this.children = new Trie[26];
            isEnd = false;
        }

        public void addWord(Trie t, String s) {

            Trie curr = t;
            if (curr == null) {
                curr = new Trie();
            }
            for (int i = 0; i < s.length(); i++) {
                if (curr.children[s.charAt(i) - 'a'] == null) {
                    curr.children[s.charAt(i) - 'a'] = new Trie();
                }
                curr = curr.children[s.charAt(i) - 'a'];

            }
            curr.isEnd = true;

        }

        public List<String> findWords(Trie t, String word) {
            Trie curr = t;
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < word.length(); i++) {
                if (curr.children[word.charAt(i) - 'a'] == null) {
                    return null;
                }
                curr = curr.children[word.charAt(i) - 'a'];
                sb.append(word.charAt(i));
            }

            List<String> rem = new ArrayList<>();
            StringBuilder temp = new StringBuilder();
            findThreeWords(curr, rem, temp);

            List<String> ans = new ArrayList<>();
            for (int i = 0; i < Math.min(rem.size(), 3); i++) {
                StringBuilder sb1 = new StringBuilder();
                sb1.append(word);
                sb1.append(rem.get(i));
                ans.add(sb1.toString());

            }

            return ans;
        }

        public void findThreeWords(Trie curr, List<String> rem, StringBuilder temp) {
            if (curr.isEnd) {
                rem.add(temp.toString());

            }
            for (int i = 0; i < 26; i++) {
                if (curr.children[i] != null) {
                    temp.append((char) (i + 97));
                    findThreeWords(curr.children[i], rem, temp);
                    temp.deleteCharAt(temp.length() - 1);
                }
            }
        }
    }

    public static void main(String[] args) {
        String[] p = { "mobile", "mouse", "moneypot", "monitor", "mousepad" };
        SearchSuggestion s = new SearchSuggestion();
        System.out.println(s.suggestedProducts(p, "mouse"));

    }
}

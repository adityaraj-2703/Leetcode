package trie;

public class LongestCommonPrefix {
    class Trie {
        Trie[] children;
        int count;

        Trie() {
            this.children = new Trie[26];
        }

        public void add(String s) {
            Trie curr = this;
            // if (this == null) {
            // curr = new Trie();
            // }

            for (int i = 0; i < s.length(); i++) {
                if (curr.children[s.charAt(i) - 'a'] == null) {
                    curr.children[s.charAt(i) - 'a'] = new Trie();

                }
                curr.children[s.charAt(i) - 'a'].count += 1;
                curr = curr.children[s.charAt(i) - 'a'];
            }
        }

        public String find(int len) {
            Trie curr = this;
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                if (curr.children[i] != null) {
                    Trie temp = curr.children[i];
                    if (temp.count != len) {
                        return sb.toString();
                    }
                    curr = curr.children[i];
                    sb.append((char) (i + 'a'));
                }
            }
            return "";
        }
    }

    public String longestCommonPrefix(String[] strs) {
        // Trie t = new Trie();
        // for (int i = 0; i < strs.length; i++) {
        // t.add(strs[i]);
        // }
        // return t.find(strs.length);

        String check = "";
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < strs.length; i++) {
            if (strs[i].length() < min) {
                min = strs[i].length();
                check = strs[i];
            }
        }
        System.out.println(check);
        for (int i = check.length(); i >= 0; i--) {
            boolean flag = true;
            for (int j = 0; j < strs.length; i++) {
                System.out.println(check.substring(0, i));
                if (!strs[j].startsWith(check.substring(0, i))) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                return check.substring(0, i);
            }
        }
        return "";

    }

    public static void main(String[] args) {
        String[] words = { "a" };
        LongestCommonPrefix lcp = new LongestCommonPrefix();
        System.out.println(lcp.longestCommonPrefix(words));
    }
}

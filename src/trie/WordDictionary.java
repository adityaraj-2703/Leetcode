package trie;

public class WordDictionary {
    WordDictionary[] children;
    boolean isEnd;
    WordDictionary root;

    public WordDictionary() {
        this.children = new WordDictionary[26];
    }

    public void addWord(String word) {
        if (root == null) {
            root = new WordDictionary();
        }
        WordDictionary curr = root;
        for (int i = 0; i < word.length(); i++) {
            if (curr.children[word.charAt(i) - 'a'] == null) {
                curr.children[word.charAt(i) - 'a'] = new WordDictionary();
            }
            curr = curr.children[word.charAt(i) - 'a'];
        }
        curr.isEnd = true;

    }

    public boolean search(String word) {
        if (root == null) {
            return false;
        }
        WordDictionary curr = root;
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) != '.' && curr.children[word.charAt(i) - 'a'] != null) {
                curr = curr.children[word.charAt(i) - 'a'];
            } else if (word.charAt(i) == '.') {
                for (int j = 0; j < 26; j++) {
                    if (curr.children[j] != null) {
                        if (dfs(word, i + 1, curr.children[j])) {
                            return true;
                        }
                    }
                }
                return false;

            } else {
                return false;
            }
        }
        return curr != null;

    }

    public boolean dfs(String word, int i, WordDictionary r) {
        if (r == null) {
            return false;
        }
        WordDictionary curr = r;
        for (int j = i; j < word.length(); j++) {
            if (word.charAt(i) != '.' && curr.children[word.charAt(j) - 'a'] != null) {
                curr = curr.children[word.charAt(j) - 'a'];
            } else if (word.charAt(j) == '.') {
                for (int k = 0; k < 26; k++) {
                    if (curr.children[k] != null) {
                        if (dfs(word, i, curr.children[k])) {
                            return true;
                        } else {
                            return false;
                        }
                    }
                }

            } else {
                return false;
            }
        }
        return curr != null;

    }

    public static void main(String[] args) {
        WordDictionary w = new WordDictionary();
        w.addWord("a");
        w.addWord("a");

        System.out.println(w.search("."));
        System.out.println(w.search("a"));
        System.out.println(w.search("aa"));
        System.out.println(w.search("a"));
        System.out.println(w.search(".a"));
        System.out.println(w.search("a."));

    }

}

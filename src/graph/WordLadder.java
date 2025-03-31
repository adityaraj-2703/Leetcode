package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> hs = new HashSet<>();
        for (int i = 0; i < wordList.size(); i++) {
            hs.add(wordList.get(i));
        }
        Queue<String> q = new LinkedList<>();
        q.add(beginWord);
        int d = 0;
        while (!q.isEmpty()) {
            d += 1;
            int l = q.size();
            for (int k = 0; k < l; k++) {
                String temp = q.poll();
                char[] c = temp.toCharArray();
                for (int i = 0; i < c.length; i++) {
                    char t = c[i];
                    for (int j = 0; j < 26; j++) {
                        char changed = (char) (j + 'a');
                        if (changed == t) {
                            continue;
                        }
                        c[i] = changed;
                        String changedS = new String(c);

                        if (hs.contains(changedS)) {
                            if (changedS.equals(endWord)) {
                                return d + 1;
                            }
                            hs.remove(changedS);
                            q.add(changedS);
                        }

                    }
                    c[i] = t;
                }
            }

        }
        return d;
    }

    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        String[] words = { "hot", "dot", "dog", "lot", "log", "cog" };
        List<String> wordT = Arrays.asList(words);

        WordLadder w = new WordLadder();
        System.out.println(w.ladderLength(beginWord, endWord, wordT));
    }

}

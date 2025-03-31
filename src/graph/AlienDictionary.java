package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AlienDictionary {
    public String alienOrder(String[] words) {
        int[] inDegree = new int[26];
        for (int i = 0; i < inDegree.length; i++) {
            inDegree[i] = -1;
        }
        List<int[]> adjList = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            adjList.add(new int[26]);
        }
        for (int i = 0; i < words.length; i++) {
            if (inDegree[words[i].charAt(0) - 'a'] == -1) {
                inDegree[words[i].charAt(0) - 'a']++;
            }
            for (int j = 1; j < words[i].length(); j++) {
                int[] arr = adjList.get(words[i].charAt(j - 1) - 'a');
                arr[words[i].charAt(j) - 'a']++;
                if (inDegree[words[i].charAt(j) - 'a'] == -1) {
                    inDegree[words[i].charAt(j) - 'a'] += 2;
                } else {
                    inDegree[words[i].charAt(j) - 'a']++;
                }

            }
        }
        Queue<Character> q = new LinkedList<>();
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                q.add((char) (i + 97));
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!q.isEmpty()) {
            char temp = q.poll();
            sb.append(temp);
            int t = temp - 'a';
            int[] arr = adjList.get(t);
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] != 0) {
                    arr[i]--;
                    if (arr[i] == 0) {
                        q.add((char) (i + 97));
                    }
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String[] words = { "wrt", "wrf", "er", "ett", "rftt" };
        AlienDictionary a = new AlienDictionary();
        System.out.println(a.alienOrder(words));
    }

}

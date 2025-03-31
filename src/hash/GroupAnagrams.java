package hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        boolean[] visit = new boolean[strs.length];
        Map<String, int[]> hm = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            if (visit[i]) {
                continue;
            }
            List<String> temp = new ArrayList<>();
            temp.add(strs[i]);
            int[] map1 = new int[26];
            for (int j = 0; j < strs[i].length(); j++) {
                map1[strs[i].charAt(j) - 'a']++;
            }
            visit[i] = true;
            for (int j = i + 1; j < strs.length; j++) {
                if (visit[j]) {
                    continue;
                }
                int[] map2 = new int[26];
                for (int k = 0; k < strs[j].length(); k++) {
                    map2[strs[j].charAt(k) - 'a']++;
                }
                if (check(map1, map2)) {
                    visit[j] = true;
                    temp.add(strs[j]);
                }
            }
            ans.add(temp);

        }
        return ans;
    }

    public boolean check(int[] a, int[] b) {
        for (int i = 0; i < 26; i++) {
            if (a[i] != b[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        GroupAnagrams g = new GroupAnagrams();
        String[] strs = { "eat", "tea", "tan", "ate", "nat", "bat" };
        System.out.println(g.groupAnagrams(strs));
    }
}

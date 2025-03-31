package hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PartitionLabels {
    public List<Integer> partitionLabels(String s) {
        Map<Character, Integer> hm = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            hm.put(s.charAt(i), i);
        }
        List<Integer> ans = new ArrayList<>();
        int i = 0;
        int j = 0;
        int max = -1;
        while (j < s.length()) {
            if (j == max) {
                ans.add(j - i + 1);
                max = -1;
                i = j + 1;
                j++;
                continue;
            }
            max = Math.max(max, hm.get(s.charAt(j)));
            j++;
        }
        return ans;
    }

    public static void main(String[] args) {
        PartitionLabels p = new PartitionLabels();
        System.out.println(p.partitionLabels("ababcbacadefegdehijhklij"));
    }

}

package hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Anagrams {
    public List<String> removeAnagrams(String[] words) {
        Set<String> hs = new HashSet<>();
        List<String> ans = new ArrayList<>();
        for(int i=0;i<words.length;i++){
            char[] ch = words[i].toCharArray();
            Arrays.sort(ch);
            String sortedWord = ch.toString();
            if(!hs.contains(sortedWord)){
                hs.add(sortedWord);
                ans.add(words[i]);
            }
            
        }
        return ans;
    }
}

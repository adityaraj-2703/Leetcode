package hash;

import java.util.HashMap;
import java.util.Map;

public class WordPattern {
    public boolean wordPattern(String pattern, String s) {
        Map<Character,String> hm = new HashMap<>();
        String[] words = s.split(" ");
        for(int i=0;i<pattern.length();i++){
            String s1 = hm.getOrDefault(pattern.charAt(i),":");
            if(s1.equals(":")){
                hm.put(pattern.charAt(i),words[i]);
            }
            else{
                if(!s1.equals(words[i])){
                    return false;
                }
            }
        }
        return true;
    }
}

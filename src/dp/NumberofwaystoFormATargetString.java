package dp;

import java.util.HashMap;
import java.util.Map;

public class NumberofwaystoFormATargetString {
    public static int numWays(String[] words, String target) {
        Map<Integer,Integer> hm = new HashMap<>();
        for(int i=0;i<words.length;i++){
            hm.put(i,0);
        }
        int ans = dp(words,target,hm,0);
        return ans;
    }
    public static int dp(String[] words, String target,Map<Integer,Integer> hm,int i){
        if(i==target.length()){
            hm = new HashMap<>();
            for(int k=0;k<words.length;k++){
                hm.put(k,0);
            }
            return 1;
        }
        boolean val = false;
        for(Map.Entry<Integer,Integer> m : hm.entrySet()){
            if(m.getValue()<words[m.getKey()].length()){
                val = true;
                break;
            }
        }
        if(!val){
            return 0;
        }
        int ans = 0;
        boolean flag = false;
        for(Map.Entry<Integer,Integer> m : hm.entrySet()){
            int wordsIndex = m.getKey();
            int wordIndex  = m.getValue();
            
            if(target.charAt(i) == words[wordsIndex].charAt(wordIndex)){
                flag = true;
                if(words[wordsIndex].length() > wordIndex+1){
                    hm.put(wordsIndex,wordIndex+1);
                }
                
                ans += dp(words,target,hm,i+1);
            }
        }
        if(!flag){
            for(Map.Entry<Integer,Integer> m : hm.entrySet()){
                if(words[m.getKey()].length() > m.getValue()+1){
                    hm.put(m.getKey(),m.getValue()+1);
                }
                
                ans += dp(words,target,hm,i);
            }
            
        }
        return ans;
    }
    public static void main(String[] args) {
        String[] words = {"abba","baab",};
        String target = "bab";
        System.out.println(numWays(words, target));
    }
}

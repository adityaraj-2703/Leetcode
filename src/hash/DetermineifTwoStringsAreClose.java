package hash;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class DetermineifTwoStringsAreClose {
    public boolean closeStrings(String word1, String word2) {
        Map<Character,Integer> hm1 = new HashMap<>();
        Map<Character,Integer> hm2 = new HashMap<>();
        
        for(int i=0;i<word1.length();i++){
            hm1.put(word1.charAt(i),hm1.getOrDefault(word1.charAt(i),0)+1);
        }
        for(int i=0;i<word2.length();i++){
            hm2.put(word2.charAt(i),hm2.getOrDefault(word2.charAt(i),0)+1);
        }
        List<Map.Entry<Character,Integer>> l1 = new LinkedList<>(hm1.entrySet());
        List<Map.Entry<Character,Integer>> l2 = new LinkedList<>(hm2.entrySet());
        Collections.sort(l1, new Comparator<Map.Entry<Character,Integer>>() {
            public int compare(Map.Entry<Character,Integer> s1, Map.Entry<Character,Integer> s2){
                return s1.getValue() - s2.getValue();
            }
        });
        Collections.sort(l2, new Comparator<Map.Entry<Character,Integer>>() {
            public int compare(Map.Entry<Character,Integer> s1, Map.Entry<Character,Integer> s2){
                return s1.getValue() - s2.getValue();
            }
        });
        if(hm1.size()!=hm2.size()){
            return false;
        }
        int[] arr = new int[hm1.size()];
        int k=0;
        for(Map.Entry<Character,Integer> e : l1){
            int l = hm2.getOrDefault(e.getKey(), -1);
            if(l==-1){
                return false;
            }
            arr[k] = e.getValue();
            k++;
        }
        k=0;
        for(Map.Entry<Character,Integer> e : l2){
            if(arr[k] != e.getValue()){
                return false;
            }
            k++;
        }
        

        return true;
    }
}

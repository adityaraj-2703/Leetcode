package heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class SortCharactersByFrequency {
    public String frequencySort(String s) {
        Map<Character,Integer> hm = new HashMap<>();
        for(int i=0;i<s.length();i++){
            hm.put(s.charAt(i),hm.getOrDefault(s.charAt(i), 0)+1);
        }
        PriorityQueue<Map.Entry<Character,Integer>> pq = new PriorityQueue<>(new Comparator<Map.Entry<Character,Integer>>() {
            public int compare(Map.Entry<Character,Integer> m1, Map.Entry<Character,Integer> m2){
                return m2.getValue() - m1.getValue();
            }
        });
        for(Map.Entry<Character,Integer> m : hm.entrySet()){
            pq.add(m);
        }
        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()){
            Map.Entry<Character,Integer> m = pq.poll();
            for(int i=0;i<m.getValue();i++){
                sb.append(m.getKey());
            }
        }
        return sb.toString();
    }
}

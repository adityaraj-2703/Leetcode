package heap;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class ReorganizeString {
    public String reorganizeString(String s) {
        Map<Character,Integer> hm = new HashMap<>();
        for(int i=0;i<s.length();i++){
            hm.put(s.charAt(i),hm.getOrDefault(s.charAt(i), 0)+1);
        }
        PriorityQueue<Map.Entry<Character,Integer>> pq = 
        new PriorityQueue<>(new Comparator<Map.Entry<Character,Integer>>() {
            public int compare(Map.Entry<Character,Integer> m1, Map.Entry<Character,Integer> m2){
                return m2.getValue() - m1.getValue();
            }
        });
        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()){
            Map.Entry<Character,Integer> m1 = pq.poll();
            Map.Entry<Character,Integer> m2 = pq.poll();
            sb.append(m1.getKey());
            m1.setValue(m1.getValue()-1);
            pq.add(m1);
            if(m2==null){
                break;
            }
            m2.setValue(m2.getValue()-1);
            pq.add(m2);


        }
        if(!pq.isEmpty()){
            return "";
        }
        return sb.toString();
    }
}

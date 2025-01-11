package heap;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class ConstructStringWithoutRepeatLimit {
    public static String repeatLimitedString(String s, int repeatLimit) {
        Map<Character,Integer> hm = new HashMap<>();
        for(int i=0;i<s.length();i++){
            hm.put(s.charAt(i),hm.getOrDefault(s.charAt(i),0)+1);
        }
        PriorityQueue<Map.Entry<Character,Integer>> pq = new PriorityQueue<>(new Comparator<Map.Entry<Character,Integer>>() {
            public int compare(Map.Entry<Character,Integer> m1,Map.Entry<Character,Integer> m2){
                return m2.getKey() - (m1.getKey());
            }
        });
        StringBuilder ans = new StringBuilder();
        pq.addAll(hm.entrySet());
        while(!pq.isEmpty()){
            Map.Entry<Character,Integer> m1 = pq.poll();
            if(m1.getValue() > repeatLimit){
                if(pq.isEmpty()){
                    for(int i=0;i<repeatLimit;i++){
                        ans.append(m1.getKey());
                        
                    }
                    return ans.toString();
                }
                Map.Entry<Character,Integer> m2 = pq.poll();
                int freq1 = m1.getValue();
                int freq2 = m2.getValue();
                while(freq1>0){
                    for(int i=0;i<Math.min(repeatLimit,freq1);i++){
                        ans.append(m1.getKey());
                    }
                    freq1-=repeatLimit;
                    if(freq1>0){
                        ans.append(m2.getKey());
                        freq2--;
                    }
                    
                }
                if(freq2!=0){
                    m2.setValue(freq2);
                    pq.add(m2);
                }
                
            }
            else{
                for(int i=0;i<m1.getValue();i++){
                    ans.append(m1.getKey());
                }
            }
        }
        return ans.toString();
    }

}

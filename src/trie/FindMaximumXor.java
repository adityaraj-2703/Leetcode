package trie;

import java.util.HashMap;
import java.util.Map;

public class FindMaximumXor {
    public int findMaximumXor(int[] arr){
        Map<String,Integer> hm = new HashMap<>();
        int max = 0;
        TrieNodeBinary t = new TrieNodeBinary();
        String[] str = new String[arr.length];
        String x = findBinaryString(arr[0]);
        t.addWord(t, x);
        hm.put(x,arr[0]);
        
        for(int i=1;i<arr.length;i++){
            String a = findBinaryString(arr[i]);
            hm.put(a,arr[i]);
            
            String ans = t.addWordAndXor(t, a);
            max = Math.max(hm.get(ans)^arr[i],max);
        }
        return max;
        
        
    }
    public String findBinaryString(int n){
        StringBuilder sb  = new StringBuilder();
        int count=0;
        while(n>0){
            int temp = n%2;
            sb.append(temp+"");
            count++;
            n = n/2;
        }
        
        for(int i=0;i<31-count;i++){
            sb.append("0");
        }
        return sb.toString();
    }

}

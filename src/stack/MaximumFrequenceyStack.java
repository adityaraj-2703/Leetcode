package stack;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;

public class MaximumFrequenceyStack {
    Map<Integer,Stack<Integer>> fs;
    Map<Integer,Integer> hm;
    int maxfreq;
    public MaximumFrequenceyStack() {
        hm = new HashMap<>();
        fs = new HashMap<>();
        
    }
    
    public void push(int val) {
        int l = hm.getOrDefault(val,0);
        int inc = l+1;
        if(l==0){
            hm.put(val,inc);
            fs.putIfAbsent(inc, new Stack<>());  // Ensure the stack for this frequency exists
            fs.get(inc).push(val); 
        }
        else{
            hm.put(val,inc);
            fs.putIfAbsent(inc, new Stack<>());  // Ensure the stack for this frequency exists
            fs.get(inc).push(val); 
            
        }
        maxfreq = Math.max(maxfreq,inc);
    }
    
    public int pop() {
        return fs.get(maxfreq).pop();
    }
}

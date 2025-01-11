package linkedelist;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class LRUCache {

    List<Integer> li;
    HashMap<Integer,Integer> lhm;
    public LRUCache(int capacity) {
        lhm = new HashMap<>();
        li = new LinkedList<>();
    }
    
    public int get(int key) {
        return lhm.getOrDefault(key, -1);
    }
    
    public void put(int key, int value) {
        if(lhm.size()==2){
            lhm.remove(li.get(0));
            li.remove(0);
        }
        else{
            lhm.put(key, value);
            li.add(key);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

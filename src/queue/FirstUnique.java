package queue;

import java.util.LinkedList;
import java.util.Queue;

public class FirstUnique {

    
    Queue<Integer> q;
    public FirstUnique(int[] nums) {
        q = new LinkedList<>();
        for(int i=0;i<nums.length;i++){
            this.q.add(nums[i]);
        }
    }
    
    public int showFirstUnique() {
        return q.peek();
    }
    
    public void add(int value) {
        if(q.contains(value)){
            q.remove(value);
        }
        else{
            q.offer(value);
        }
    }
}

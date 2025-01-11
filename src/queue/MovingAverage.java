package queue;

import java.util.*;

public class MovingAverage {

    Queue<Integer> q;
    int size;
    int sum;
    public MovingAverage(int size) {
        this.size = size;
        q = new LinkedList<>();
    }
    
    public double next(int val){
        if(q.size()==size){
            sum -=q.poll();
        }
        else{
            size++;
        }
        
        sum+=val;
        q.add(val);
        return (double)sum/q.size();
    }
}

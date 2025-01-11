package queue;

public class ArrayQueue {
    int[] queue;
    int capacity;
    int f;
    int r;
    int flag;
    ArrayQueue(int capacity){
        this.capacity = capacity;
        queue = new int[this.capacity];
        f=0;r=0;
    }

    public int enqueue(int v){
        if(isFull()){
            return -1;
        }
        queue[r] = v;
        r = (r+1)%capacity;
        if(f==r){
            flag=1;
        }
        return r;
    }
    public int dequeue(){
        if(isEmpty()){
            return -1;
        }
        f++;
        if(f==r){
            flag=0;
        }
        return queue[f];
        
    }
    public int front(){
        if(isEmpty()){
            return -1;
        }
        return queue[f];
    }
    public boolean isEmpty(){
        if(flag==0){
            return true;
        }
        return false;
    }
    public boolean isFull(){
        if(flag==1){
            return true;
        }
        return false;
    }



}

package queue;

public class DoubleEndedQueue {
    int[] arr;
    int f;
    int r;
    int k;
    public DoubleEndedQueue(int k){
        this.k = k;
        arr = new int[this.k];
        f=-1;
        r=0;
    }
    public boolean insertFront(int val){
        if(isFull()){
            return false;
        }
        if(f==-1){
            f=0;
            r=0;
        }
        else if(f==0){
            f = k-1;
        }
        else{
            f = f-1;
        }
        arr[f] = val;
        return true;
    }
    public boolean insertLast(int val){
        if(isFull()){
            return false;
        }
        if(f==-1){
            f=0;
            r=0;
        }
        else if(r==k-1){
            r=0;
        }
        else{
            r = r+1;
        }
        arr[r] = val;
        return true;
    }
    public void deleteFront(){
        if(isEmpty()){
            return;
        }
        if(f==r){
            f=-1;
            r=-1;
        }
        else if(f == k-1){
            f=0;
        }
        else{
            f = f+1;
        }
        
        
    }
    public void deleteLast(){
        if(isEmpty()){
            return;
        }
        if(f==r){
            r=-1;
            f=-1;
        }
        else if(r==0){
            r = k-1;
        }
        else{
            r = r-1;
        }
        
    }
    public int getFront(){
        if(isEmpty()){
            return -1;
        }
        return arr[f];
    }
    public int getLast(){
        if(isEmpty()){
            return -1;
        }
        return arr[r];
    }
    
    public boolean isFull(){
        if(f==0 && r==k-1 || f ==r+1){
            return true;
        }
        return false;
    }
    public boolean isEmpty(){
        return f==-1;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */

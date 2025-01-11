package stack;

public class CustomStackIncrement {

    int[] st;
    int maxSize;
    int top;
    public CustomStackIncrement(int maxSize) {
        this.maxSize = maxSize;
        st = new int[this.maxSize];
        top = -1;
    }
    
    public void push(int x) {
        if(top == maxSize-1){
            return;
        }
        this.top++;
        st[top] = x;
        
    }
    
    public int pop() {
        if(top==-1){
            return -1;
        }
        int temp = st[top];
        top--;
        return temp;
    }
    
    public void increment(int k, int val) {
        if(k>maxSize){
            k = maxSize;
        }
        for(int i=0;i<k;i++){
            st[i] += val;
        }
    }
    public int peek(){
        return st[top];
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */

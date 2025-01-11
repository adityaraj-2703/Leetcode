package stack;

import java.util.Stack;

public class MaxAndMin {
    public int subArrayRanges(int[] A) {
        int n = A.length;
        //nextGreater
        int[] nextGreater = new int[n];
        Stack<Pair> st = new Stack<>();
        st.push(new Pair(A[n-1],n-1));
        nextGreater[n-1] = n;
        for(int i = n-2;i>=0;i--){
            while(!st.isEmpty() && st.peek().a <= A[i] ){
                st.pop();
            }
            if(!st.isEmpty()){
                nextGreater[i] = st.peek().b;
                st.push(new Pair(A[i],i));
            }
            else{
                nextGreater[i] = n;
                st.push(new Pair(A[i],i));
            }
        }
        //prevGreater
        st = new Stack<>();
        int[] prevGreater = new int[n];
        prevGreater[0] = -1;
        st.push(new Pair(A[0],0));
        for(int i=1;i<A.length;i++){
            while(!st.isEmpty() && st.peek().a <= A[i]){
                st.pop();
            }
            if(!st.isEmpty()){
                prevGreater[i] = st.peek().b;
                st.push(new Pair(A[i],i));
            }
            else{
                prevGreater[i] = -1;
                st.push(new Pair(A[i],i));
            }
        }
        //prevSmaller
        int[] prevSmaller = new int[A.length];
        st = new Stack<>();
        
        st.push(new Pair(A[0],0));
        prevSmaller[0] = -1;
        for(int i=1;i<A.length;i++){
            while(!st.isEmpty() && st.peek().a >= A[i]){
                st.pop();
            }
            if(!st.isEmpty()){
                prevSmaller[i] = st.peek().b;
                st.push(new Pair(A[i],i));
            }
            else{
                prevSmaller[i] = -1;
                st.push(new Pair(A[i],i));
            }
        }
        //nextSmaller
        int[] nextSmaller = new int[A.length];
        st = new Stack<>();
        st.push(new Pair(A[A.length-1],A.length-1));
        
        nextSmaller[A.length-1] = A.length;
        for(int i=A.length-2;i>=0;i--){
            while(!st.isEmpty() && st.peek().a >= A[i]){
                st.pop();
            }
            if(!st.isEmpty()){
                nextSmaller[i] = st.peek().b;
                st.push(new Pair(A[i],i));
            }
            else{
                nextSmaller[i] = A.length;
                st.push(new Pair(A[i],i));
            }

        }
        long sum = 0;

        for(int i=0;i<A.length;i++){
            long p1 = prevGreater[i];
            long p2 = nextGreater[i];
            sum = (sum + ((long)(i-p1) * (p2-i) * A[i])) ;

            p1 = prevSmaller[i];
            p2 = nextSmaller[i];
            sum = (sum - ((long)(i-p1) * (p2-i) * A[i])) ;
        }
        return (int)(sum%1000000007);


    }
}
class Pair{
    int a;
    int b;
    Pair(int a,int b){
        this.a = a;
        this.b = b;
    }
}


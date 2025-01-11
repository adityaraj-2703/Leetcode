package heap;

import java.util.PriorityQueue;

public class MedianInDataStream {

    PriorityQueue<Integer> pq1;
    PriorityQueue<Integer> pq2;
    public MedianInDataStream() {
        pq1 = new PriorityQueue<>((n1,n2)->n2-n1);
        pq2 = new PriorityQueue<>((n1,n2)->n1-n2);
    }
    
    public void addNum(int num) {
        if(pq1.isEmpty()){
            pq1.add(num);
        }
        else if(pq1.size()==pq2.size()){
            if(pq1.peek() > num){
                pq1.add(num);
            }
            else{
                pq2.add(num);
            }
        }
        else{
            if(num < pq1.peek()){
                while(!pq1.isEmpty() && pq1.peek() > num){
                    int t = pq1.poll();
                    pq2.add(t);
                }
                pq1.add(num);
            }
            else{
                pq2.add(num);
            }
            
        }
    }
    
    public double findMedian() {
        if(pq1.size() == pq2.size()){
            double temp1 = pq1.peek();
            double temp2 = pq2.peek();
            return (temp1 + temp2) / 2;
        }
        else{
            if(pq2.isEmpty()){
                return (long)pq1.peek();
            }
            if(pq1.size() > pq2.size()){
                return pq1.peek();
            }
            return (long)pq2.peek();
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */

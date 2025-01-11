package heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KthLargestString {
    public String kthLargestNumber(String[] nums, int k) {
        int n = nums.length;
        
        PriorityQueue<String> pq = new PriorityQueue<>(new Comparator<String>() {
            public int compare(String a,String b){
                if(a.length()!=b.length()){
                    return a.length() - b.length();
                }
                else{
                    return a.compareTo(b);
                }
            }
            
        });
        for(int i=0;i<n;i++){
            pq.add(nums[i]);
        }
        for(int i=0;i<nums.length-k;i++){
            pq.poll();
            
        }
        return pq.poll();
    }
}

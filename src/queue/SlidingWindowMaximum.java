package queue;

public class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        DoubleEndedQueue q = new DoubleEndedQueue(k);
        int[] ans = new int[nums.length-k+1];
        for(int i=0;i<k;i++){
            while(!q.isEmpty() && nums[q.getLast()] < nums[i]){
                q.deleteLast();
            }
            q.insertLast(i);
            
        }
        ans[0] = nums[q.getFront()];
        int counter = 1;
        for(int i=k;i<nums.length;i++){
            while(!q.isEmpty() && nums[q.getLast()] < nums[i]){
                q.deleteLast();
            }
            while(!q.isEmpty() && q.getFront() <= i-k){
                q.deleteFront();
            }
            q.insertLast(i);
            
            ans[counter] = nums[q.getFront()];
            counter++;
            
        }
        return ans;
    }
}

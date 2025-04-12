package heap;

import java.util.PriorityQueue;

public class KthLargest {
    PriorityQueue<Integer> pq;

    public KthLargest(int k, int[] nums) {
        pq = new PriorityQueue<>((n1, n2) -> n1 - n2);
        for (int i = 0; i < nums.length; i++) {
            pq.add(nums[i]);
            if (pq.size() > k) {
                pq.poll();
            }
        }
    }

    public int add(int val) {

        pq.add(val);
        pq.poll();
        int ans = pq.peek();

        return ans;
    }

    public static void main(String[] args) {
        int[] nums = { 4, 5, 8, 2 };
        KthLargest kl = new KthLargest(3, nums);
        System.out.println(kl.add(3)); // returns 4
        System.out.println(kl.add(5)); // returns 5
        System.out.println(kl.add(10)); // returns 5
        System.out.println(kl.add(9)); // returns 8
        System.out.println(kl.add(4)); // returns 8
    }
}

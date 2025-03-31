package dp;

public class MaximumAbsoluteSumOfSubarray {
    public int maxAbsoluteSum(int[] nums) {
        int[] pre = new int[nums.length + 1];
        for (int i = 1; i < pre.length; i++) {
            pre[i] = pre[i - 1] + nums[i - 1];
        }
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int ans = 0;
        for (int i = 1; i < pre.length; i++) {

            if (pre[i] < min) {
                min = pre[i];
            }
            if (pre[i] > max) {
                max = pre[i];
            }
            ans = Math.max(ans, Math.abs(pre[i] - min));

        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = { 1, -3, 2, 3, -4 };
        MaximumAbsoluteSumOfSubarray m = new MaximumAbsoluteSumOfSubarray();
        System.out.println(m.maxAbsoluteSum(arr));
    }

}

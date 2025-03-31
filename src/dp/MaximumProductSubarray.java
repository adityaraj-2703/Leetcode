package dp;

public class MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int min = nums[0];
        int max = nums[0];
        int res = 1;
        for (int i = 1; i < nums.length; i++) {
            res *= nums[i];
            max = Math.max(res * max, res * min);
            min = Math.min(res * max, res * min);
            if (max == 0 || min == 0) {
                max = 1;
                min = 1;
            }
        }
        return Math.max(max, min);
    }

    public static void main(String[] args) {
        int[] arr = { 2, 3, -2, 4 };
        MaximumProductSubarray m = new MaximumProductSubarray();
        System.out.println(m.maxProduct(arr));
    }

}

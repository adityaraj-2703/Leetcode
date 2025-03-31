package searching;

public class MaximumCountofPositiveNegativeNumber {
    public int maximumCount(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        int ans = nums.length;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (nums[m] > 0) {
                ans = m;
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        l = 0;
        r = nums.length - 1;
        int ans1 = 0;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (nums[m] < 0) {
                ans = m;
                l = m + 1;
            } else {
                r = m - 1;
            }
        }

        return 0;

    }

    public static void main(String[] args) {
        int[] nums = { -2, -1, -1, 1, 2, 3 };
        MaximumCountofPositiveNegativeNumber m = new MaximumCountofPositiveNegativeNumber();
        System.out.println(m.maximumCount(nums));
    }

}

package dp;

public class LargestNonDecreasingSubArrayFromTwoArray {
    public int maxNonDecreasingLength(int[] nums1, int[] nums2) {
        int[] dp = new int[nums1.length];

        int ans = 1;
        for (int index = 0; index < nums1.length - 1; index++) {
            int count = 1;
            dp[index] = Math.min(nums1[index], nums2[index]);
            for (int i = index + 1; i < nums1.length; i++) {
                int min = dp[i - 1];
                if (min <= nums1[i] && min <= nums2[i]) {
                    dp[i] = Math.min(nums1[i], nums2[i]);
                } else if (min <= nums2[i] || min <= nums1[i]) {
                    dp[i] = Math.max(nums1[i], nums2[i]);
                } else {
                    return count;
                }
                count++;
            }
            ans = Math.max(count, ans);
        }

        return ans;
    }

    public static void main(String[] args) {
        LargestNonDecreasingSubArrayFromTwoArray l = new LargestNonDecreasingSubArrayFromTwoArray();
        int[] nums1 = { 8, 7, 4 };
        int[] nums2 = { 13, 4, 4 };
        System.out.println(l.maxNonDecreasingLength(nums1, nums2));
    }
}

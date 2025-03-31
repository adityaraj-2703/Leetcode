package searching;

public class SearchInRotatedArray {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int search(int[] nums, int target) {
        int ind = findMin(nums);
        int ans = -1;
        if (target >= nums[ind]) {
            ans = search(nums, target, 0, ind);
        } else {
            ans = search(nums, target, ind, nums.length - 1);
        }
        return ans;

    }

    public int search(int[] nums, int target, int l, int r) {
        int ans = -1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (nums[m] == target) {
                ans = m;
                return m;
            } else if (nums[m] > target) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return ans;
    }

    public int findMin(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        int ans = 0;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (nums[m] < nums[0]) {
                ans = m;
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = { 3, 1 };
        int target = 3;
        SearchInRotatedArray s = new SearchInRotatedArray();
        System.out.println(s.search(nums, target));
    }
}

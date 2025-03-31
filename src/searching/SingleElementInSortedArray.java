package searching;

public class SingleElementInSortedArray {
    public int singleNonDuplicate(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (m == 0) {
                if (nums[m + 1] != nums[m]) {
                    return nums[m];
                } else {
                    l = m + 1;
                }
            } else if (m == nums.length - 1) {
                if (nums[m - 1] != nums[m]) {
                    return nums[m];
                } else {
                    r = m - 1;
                }
            } else {
                if (nums[m - 1] != nums[m] && nums[m] != nums[m + 1]) {
                    return nums[m];
                }
                int lastOcc = nums[m + 1] == nums[m] ? m + 1 : m;
                if (lastOcc % 2 == 0) {
                    r = m - 1;
                } else {
                    l = m + 1;
                }
            }

        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 1, 2, 3, 3, 4, 4, 8, 8 };
        SingleElementInSortedArray s = new SingleElementInSortedArray();
        System.out.println(s.singleNonDuplicate(arr));
    }

}

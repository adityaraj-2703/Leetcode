package searching;

public class ZeroArrayTransformation2 {
    public int minZeroArray(int[] nums, int[][] queries) {
        int[] diff = new int[nums.length];
        for (int i = 0; i < queries.length; i++) {
            diff[queries[i][0]] += queries[i][2];
            if (queries[i][1] + 1 < nums.length) {
                diff[queries[i][0]] -= queries[i][2];
            }
            if (find(nums, diff)) {
                return i + 1;
            }
        }
        return -1;
    }

    public boolean find(int[] nums, int[] diff) {

        for (int i = 0; i < diff.length; i++) {
            if (i > 0) {
                diff[i] += diff[i - 1];
            }

            if (nums[i] > diff[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] nums = { 10 };
        int[][] queries = { { 0, 0, 5 }, { 0, 0, 3 }, { 0, 0, 2 } };
        ZeroArrayTransformation2 z = new ZeroArrayTransformation2();
        System.out.println(z.minZeroArray(nums, queries));
    }

}

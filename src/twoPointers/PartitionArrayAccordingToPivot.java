package twoPointers;

public class PartitionArrayAccordingToPivot {
    public int[] pivotArray(int[] nums, int pivot) {
        int[] ans = new int[nums.length];
        int x = 0;
        int y = ans.length - 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < pivot) {
                ans[x++] = nums[i];
            } else if (nums[i] > pivot) {
                ans[y--] = nums[i];
            }
        }
        for (int i = x; i <= y; i++) {
            ans[i] = pivot;
        }
        int i = y + 1;
        int j = nums.length - 1;
        while (i < j) {
            int temp = ans[i];
            ans[i] = ans[j];
            ans[j] = temp;
            i++;
            j--;
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] arr = { 9, 12, 5, 10, 14, 3, 10 };
        int pivot = 10;
        PartitionArrayAccordingToPivot p = new PartitionArrayAccordingToPivot();
        System.out.println(p.pivotArray(arr, pivot));
    }

}

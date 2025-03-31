package hash;

import java.util.HashMap;
import java.util.Map;

public class ContiguousArray {
    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> hm = new HashMap<>();
        hm.put(0, -1);
        int max = 0;
        if (nums[0] == 0) {
            hm.put(-1, 0);

            nums[0] = -1;
        } else {
            hm.put(1, 0);
        }
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == 0) {
                nums[i] = nums[i - 1] - 1;
            } else {
                nums[i] = nums[i - 1] + 1;
            }
            if (hm.containsKey(nums[i])) {
                max = Math.max(i - hm.get(nums[i]), max);
            } else {
                hm.put(nums[i], i);
            }

        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = { 0, 1 };
        ContiguousArray c = new ContiguousArray();
        System.out.println(c.findMaxLength(arr));
    }

}

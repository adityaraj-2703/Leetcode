package dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class LargestDivisibleSubset {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        // if (nums.length == 1) {
        // List<Integer> ans = new ArrayList<>();
        // ans.add(nums[0]);
        // return ans;
        // }
        // List<List<Integer>> al = new ArrayList<>();
        // List<Integer> temp = new ArrayList<>();
        // largestDivisibleSubsetUtil(nums, al, temp, 0);
        // int max = 0;
        // int j = 0;
        // for (int i = 0; i < al.size(); i++) {
        // if (max < al.get(i).size()) {
        // max = al.get(i).size();
        // j = i;
        // }
        // }
        // return al.get(j);
        Map<Integer, Set<Integer>> hm = new HashMap<>();
        int max = 0;
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            Set<Integer> hs = hm.getOrDefault(i, new HashSet<>());
            for (int j = 0; j <= i; j++) {
                if (nums[i] % nums[j] == 0) {
                    hs.add(nums[j]);
                }
            }
            hm.put(i, hs);
            if (max < hs.size()) {
                max = hs.size();
                ans = new ArrayList<>(hs);
            }
        }
        return ans;

    }

    public void largestDivisibleSubsetUtil(int[] nums, List<List<Integer>> al, List<Integer> temp, int ind) {
        if (ind == nums.length) {
            al.add(new ArrayList<>(temp));
            return;
        }
        for (int i = ind; i < nums.length; i++) {
            if (temp.size() == 0 || nums[i] % temp.get(temp.size() - 1) == 0) {
                temp.add(nums[i]);
                largestDivisibleSubsetUtil(nums, al, temp, i + 1);
                temp.remove(temp.size() - 1);
            } else {
                largestDivisibleSubsetUtil(nums, al, temp, i + 1);
            }
        }

    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3 };
        LargestDivisibleSubset l = new LargestDivisibleSubset();
        List<Integer> ans = l.largestDivisibleSubset(nums);
        for (int i = 0; i < ans.size(); i++) {
            System.out.print(ans.get(i) + " ");
        }
    }

}

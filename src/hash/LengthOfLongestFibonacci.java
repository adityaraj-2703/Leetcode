package hash;

import java.util.HashMap;
import java.util.Map;

public class LengthOfLongestFibonacci {
    public int lenLongestFibSubseq(int[] arr) {
        Map<Integer, Integer> hm = new HashMap<>();
        hm.put(arr[0], 1);
        for (int i = 1; i < arr.length; i++) {

            int count = hm.size();
            // if (!hm.containsKey(arr[i])) {
            // count++;
            // }
            int ind = 0;
            hm.put(arr[i], hm.getOrDefault(arr[i], 0) + 1);
            for (Map.Entry<Integer, Integer> m : hm.entrySet()) {
                if (ind == count) {
                    break;
                }
                int temp = arr[i] + m.getKey();
                if (hm.containsKey(temp)) {
                    hm.put(temp, Math.max(hm.get(temp), m.getValue() + 1));
                } else {
                    hm.put(temp, m.getValue() + 1);
                }
                ind++;

            }
        }
        int max = 1;
        for (Map.Entry<Integer, Integer> m : hm.entrySet()) {
            max = Math.max(max, m.getValue());
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8 };
        LengthOfLongestFibonacci l = new LengthOfLongestFibonacci();
        System.out.println(l.lenLongestFibSubseq(arr));
    }

}

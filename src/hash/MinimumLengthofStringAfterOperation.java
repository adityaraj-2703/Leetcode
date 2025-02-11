package hash;

import java.util.HashMap;
import java.util.Map;

public class MinimumLengthofStringAfterOperation {
    public static void main(String[] args) {
        MinimumLengthofStringAfterOperation m = new MinimumLengthofStringAfterOperation();
        System.out.println(m.minimumLength("abaacbcbb"));
    }

    public int minimumLength(String s) {
        Map<Character, Pair> hm = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            Pair p = hm.getOrDefault(s.charAt(i), null);
            if (p == null) {
                hm.put(s.charAt(i), new Pair(i, -1));
            } else {
                if (p.middle == -1) {
                    hm.put(s.charAt(i), new Pair(hm.get(s.charAt(i)).left, i));
                } else {
                    hm.put(s.charAt(i), new Pair(hm.get(s.charAt(i)).middle, -1));
                }
            }
        }
        int sum = 0;
        for (Map.Entry<Character, Pair> m : hm.entrySet()) {
            Pair p = m.getValue();
            if (p.middle == -1) {
                sum += 1;
            } else {
                sum++;
            }
        }
        return sum;
    }

    class Pair {
        int left;
        int middle;

        Pair(int left, int middle) {
            this.left = left;
            this.middle = middle;
        }
    }

}

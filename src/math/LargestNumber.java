package math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LargestNumber {
    public String largestNumber(int[] nums) {
        
        List<String> numList = new ArrayList<>();
        for (int num : nums) {
            numList.add(String.valueOf(num));
        }
        
        Collections.sort(numList, new Comparator<String>() {
            public int compare(String a, String b) {
                return (b+a).compareTo(a + b); // Compare concatenated results
            }
        });
        StringBuilder result = new StringBuilder();
        for (String num : numList) {
            result.append(num);
        }
        return result.toString();
        
    }
}

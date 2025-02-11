package hash;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class NumberContainers {
    Map<Integer, Set<Integer>> min = new HashMap<>();
    Map<Integer, Integer> hm = new HashMap<>();

    public NumberContainers() {

    }

    public void change(int index, int number) {
        if (hm.containsKey(index)) {
            Set<Integer> tempSet = min.get(number);
            tempSet.remove(index);
        }
        hm.put(index, number);
        if (min.containsKey(number)) {
            Set<Integer> tempSet = min.get(number);
            tempSet.add(index);
            min.put(number, tempSet);
        } else {
            Set<Integer> tempSet = new TreeSet<>();
            tempSet.add(index);
            min.put(number, tempSet);
        }

    }

    public int find(int number) {
        if (min.containsKey(number)) {
            Set<Integer> hs = min.get(number);
            for (int num : hs) {
                return num;
            }
        }
        return -1;

    }

}

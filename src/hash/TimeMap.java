package hash;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

class TimeMap {
    Map<String, List<Pair>> hm;

    public TimeMap() {
        hm = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        List<Pair> al = hm.getOrDefault(key, new ArrayList<>());
        al.add(new Pair(value, timestamp));
        hm.put(key, al);

    }

    public String get(String key, int timestamp) {
        if (!hm.containsKey(key)) {
            return "";
        }
        int l = 0;
        List<Pair> temp = hm.get(key);
        int r = temp.size() - 1;
        Pair ans = null;
        while (l <= r) {
            int m = (l + r) / 2;
            if (temp.get(m).ts <= timestamp) {
                ans = temp.get(m);
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        if (ans == null) {
            return "";
        }
        return ans.val;
    }

    class Pair {
        String val;
        int ts;

        Pair(String val, int ts) {
            this.val = val;
            this.ts = ts;
        }
    }
}

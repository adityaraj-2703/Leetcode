package backtracking;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> al = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        combineUtil(n, k, al, temp, 1);
        return al;
    }

    public void combineUtil(int n, int k, List<List<Integer>> al, List<Integer> temp, int ind) {
        if (temp.size() == k) {
            al.add(new ArrayList<>(temp));
            return;
        }

        for (int i = ind; i <= n; i++) {
            if (!temp.contains(i)) {
                temp.add(i);
                combineUtil(n, k, al, temp, i + 1);
                temp.remove(temp.size() - 1);
            }

        }

    }

    public static void main(String[] args) {
        Combinations c = new Combinations();
        System.out.println(c.combine(4, 2));
    }

}

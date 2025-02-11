package backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Permutations3 {
    public int[][] permute(int n) {
        List<List<Integer>> al = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        permuteUtil(n, al, temp, -1);
        int[][] ans = new int[al.size()][n];
        for (int i = 0; i < al.size(); i++) {
            for (int j = 0; j < al.get(i).size(); j++) {
                ans[i][j] = al.get(i).get(j);
            }
        }
        return ans;
    }

    public void permuteUtil(int n, List<List<Integer>> al, List<Integer> temp, int last) {
        if (temp.size() == n) {
            al.add(new ArrayList<>(temp));
            // return;
        }
        for (int i = 1; i <= n; i++) {
            if (temp.isEmpty()) {
                temp.add(i);
                permuteUtil(n, al, temp, i);
            } else if (temp.contains(i)) {
                continue;
            } else {

                if (last % 2 == 0) {
                    if (i % 2 == 0) {
                        continue;
                    } else {
                        temp.add(i);
                        permuteUtil(n, al, temp, i);
                    }
                } else {
                    if (i % 2 != 0) {
                        continue;
                    } else {
                        temp.add(i);
                        permuteUtil(n, al, temp, i);
                    }
                }
            }
            if (temp.size() > 0) {
                temp.remove(temp.size() - 1);
            }

        }
    }

    public static void main(String[] args) {
        Permutations3 p = new Permutations3();
        int[][] ans = p.permute(4);
        for (int i = 0; i < ans.length; i++) {
            for (int j = 0; j < ans[i].length; j++) {
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        }
    }

}

package backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LexicographicallyLargestSequence {
    public int[] constructDistancedSequence(int n) {
        boolean[] visited = new boolean[n + 1];
        int[] temp = new int[n * 2 - 1];
        constructDistancedSequenceUtil(temp, visited, n, 0);
        return temp;
    }

    public boolean constructDistancedSequenceUtil(int[] temp, boolean[] visited,
            int n, int ind) {
        if ((ind == temp.length)) {
            return true;
        }
        if (temp[ind] != 0)
            return constructDistancedSequenceUtil(temp, visited, n, ind + 1);
        for (int i = n; i >= 1; i--) {
            if (visited[i]) {
                continue;
            }
            if (i == 1) {
                temp[i] = 1;
                visited[i] = true;
                if (constructDistancedSequenceUtil(temp, visited, n, ind + 1)) {
                    return true;
                }
                temp[i] = 0;
                visited[i] = false;
            } else {
                int nextIndex = ind + i;
                if (nextIndex < temp.length && temp[nextIndex] == 0) {
                    temp[ind] = i;
                    temp[nextIndex] = i;
                    visited[i] = true;
                    if (constructDistancedSequenceUtil(temp, visited, n, ind + 1)) {
                        return true;
                    }
                    temp[ind] = 0;
                    temp[nextIndex] = 0;
                    visited[ind] = false;
                }

            }

        }
        return false;

    }

    public static void main(String[] args) {
        LexicographicallyLargestSequence l = new LexicographicallyLargestSequence();
        int[] ans = l.constructDistancedSequence(5);
        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i] + " ");
        }
    }

}

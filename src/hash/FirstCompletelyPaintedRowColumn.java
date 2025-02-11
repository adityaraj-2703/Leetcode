package hash;

import java.util.HashMap;
import java.util.Map;

public class FirstCompletelyPaintedRowColumn {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        Map<Integer, Pair> hm = new HashMap<>();
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                hm.put(mat[i][j], new Pair(i, j));
            }
        }
        int m = mat.length;
        int n = mat[0].length;
        Map<Integer, Integer> rowCount = new HashMap<>();
        Map<Integer, Integer> colCount = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            Pair temp = hm.get(arr[i]);
            rowCount.put(temp.row, rowCount.getOrDefault(temp.row, 0) + 1);
            colCount.put(temp.col, rowCount.getOrDefault(temp.col, 0) + 1);
            if (rowCount.get(temp.row) == m || colCount.get(temp.col) == n) {
                return i;
            }

        }
        return -1;

    }

    public static void main(String[] args) {
        FirstCompletelyPaintedRowColumn f = new FirstCompletelyPaintedRowColumn();
        int[] arr = { 1, 4, 5, 2, 6, 3 };
        int[][] mat = { { 4, 3, 5 }, { 1, 2, 6 } };
        System.out.println(f.firstCompleteIndex(arr, mat));
    }

    static class Pair {
        int row;
        int col;

        Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

}

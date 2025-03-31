package matrix;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ValidSuduku {
    public boolean isValidSudoku(char[][] board) {
        Map<Integer, Set<Integer>> rowMap = new HashMap<>();
        Map<Integer, Set<Integer>> colMap = new HashMap<>();
        Map<Integer, Set<Integer>> boxMap = new HashMap<>();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] != '.') {
                    int temp = board[i][j] - '0';
                    Set<Integer> rowSet = rowMap.getOrDefault(i, new HashSet<>());
                    if (rowSet.contains(temp)) {
                        return false;
                    } else {
                        rowSet.add(temp);
                        rowMap.put(i, rowSet);
                    }

                    Set<Integer> colSet = colMap.getOrDefault(j, new HashSet<>());
                    if (colSet.contains(temp)) {
                        return false;
                    } else {
                        colSet.add(temp);
                        colMap.put(j, colSet);
                    }

                    Set<Integer> boxSet = boxMap.getOrDefault((i / 3 + j / 3), new HashSet<>());
                    if (boxSet.contains(temp)) {
                        return false;
                    } else {
                        boxSet.add(temp);
                        boxMap.put((i / 3 + j / 3), boxSet);
                    }

                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        ValidSuduku v = new ValidSuduku();
        char[][] board = { { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
                { '6', '.', '.', '1', '9', '5', '.', '.', '.' },
                { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
                { '8', '.', '.', '.', '6', '.', '.', '.', '3' },
                { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
                { '7', '.', '.', '.', '2', '.', '.', '.', '6' },
                { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
                { '.', '.', '.', '4', '1', '9', '.', '.', '5' },
                { '.', '.', '.', '.', '8', '.', '.', '7', '9' } };
        System.out.println(v.isValidSudoku(board));
    }
}

package searching;

public class SearchIna2dMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int l1 = 0;
        int r1 = matrix.length - 1;
        int n = matrix[0].length;
        int row = 0;
        while (l1 <= r1) {
            int m = l1 + (r1 - l1) / 2;
            System.out.println(matrix[m][n - 1]);
            if (matrix[m][n - 1] >= target) {
                row = m;
                r1 = m - 1;
            } else {
                l1 = m + 1;
            }
        }
        int l2 = 0;
        int r2 = matrix[0].length;
        while (l2 <= r2) {
            int m = l2 + (r2 - l2) / 2;
            if (matrix[row][m] == target) {
                return true;
            } else if (matrix[row][m] < target) {
                l2 = m + 1;
            } else {
                r2 = m - 1;
            }
        }
        return false;

    }

    public static void main(String[] args) {
        int[][] matrix = { { 1 } };
        int target = 2;
        SearchIna2dMatrix s = new SearchIna2dMatrix();
        System.out.println(s.searchMatrix(matrix, target));
    }

}

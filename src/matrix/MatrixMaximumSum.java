package matrix;

public class MatrixMaximumSum {
    public long maxMatrixSum(int[][] matrix) {
        int max = Integer.MIN_VALUE;
        int countNR = 0;
        int sum=0;
        for(int i=0;i<matrix.length;i++){
            int sm = Integer.MAX_VALUE;
            int countN = 0;
            for(int j=0;j<matrix[i].length;j++){
                sm = Math.min(sm,Math.abs(matrix[i][j]));
                sum += Math.abs(matrix[i][j]);
                if(matrix[i][j] < 0){
                    countN++;
                    max = Math.max(max,matrix[i][j]);
                }
            }
            if(countN%2!=0){
                countNR++;
            }

        }
        if(countNR%2!=0){
            return sum += 2*max;
        }
        return sum;
    }
}

package twoPointers;

public class ClosestPairofSortedArrays {
    public int[] solve(int[] A, int[] B, int C) {
        int i = 0;
        int j = A.length-1;
        int ansi = -1;
        int ansj = -1;
        int ans = Integer.MAX_VALUE;
        while(i<A.length && j>=0){
            int temp = Math.abs((A[i] + B[j]) - C);
            if(temp < ans){
                ans = temp;
                ansi = i;
                ansj = j;
                i++;
            }
            else if(temp==ans){
                if(ansi!=-1 && ansj!=-1){
                    if(ansj > j){
                        ansi = i;
                        ansj = j;
                    }
                }
                i++;
            }
            else{
                j--;
            }
        }
        int[] ans1 = new int[2];
        ans1[0] = A[ansi];
        ans1[1] = B[ansj];
        return ans1;
    }
}

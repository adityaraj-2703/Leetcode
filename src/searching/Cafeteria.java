package searching;

import java.util.Arrays;

public class Cafeteria {
    public long getMaxAdditionalDinersCount(long N, long K, int M, long[] S) {
        // Write your code here
        long l = 1;
        long r = N / (K + 1);
        long ans = -1;
        Arrays.sort(S);
        while (l <= r) {
            long m = l + (r - l) / 2;
            int count = 0;
            long ini = 1;
            int pointer = 0;
            while (ini <= N) {
                if (pointer < S.length && ini + K >= S[pointer]) {

                    ini = S[pointer] + K + 1;
                    pointer++;
                } else {
                    count++;
                    ini = ini + K + 1;
                }
                if (count == m) {
                    break;
                }
            }
            if (count >= m) {
                ans = m;
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Cafeteria c = new Cafeteria();
        long N = 10;
        long K = 1;
        int M = 2;
        long[] S = { 2, 6 };
        System.out.println(c.getMaxAdditionalDinersCount(N, K, M, S));
    }

}

package math;

public class ClosestPrimeNumberInRange {
    public int[] closestPrimes(int left, int right) {
        if (right <= 2) {
            return new int[] { -1, -1 };
        }
        boolean[] prime = new boolean[right + 1];
        prime[1] = false;
        prime[2] = true;
        for (int i = 2; i * i <= right; i++) {
            for (int j = 2 * i; j <= right; j += 2) {
                prime[j] = true;
            }
        }
        int s = Integer.MAX_VALUE;
        int min = Integer.MAX_VALUE;
        int[] ans = new int[2];
        ans[0] = s;
        for (int i = left; i <= right; i++) {
            if (!prime[i]) {

                if (min > Math.abs(s - i)) {
                    min = Math.min(min, Math.abs(s - i));
                    ans[0] = s;
                    ans[1] = i;
                }
                s = i;
            }
        }
        if (ans[0] == Integer.MAX_VALUE) {
            return new int[] { -1, -1 };
        }
        return ans;
    }

    public boolean prime(int n) {
        if (n == 1) {
            return false;
        }
        if (n == 2) {
            return true;
        }
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int low = 10;
        int high = 19;
        ClosestPrimeNumberInRange c = new ClosestPrimeNumberInRange();
        int[] ans = c.closestPrimes(low, high);
        System.out.println(ans[0] + " , " + ans[1]);
    }

}

package math;

public class CheckIfNumberisSumOfPower3 {
    public boolean checkPowersOfThree(int n) {
        int prev = -1;
        while (n > 0) {
            int temp = find(n, 3);
            if (prev == temp) {
                return false;
            }
            prev = temp;
            n = n - (int) Math.pow(3, temp);
        }
        return true;
    }

    public int find(int n, int d) {
        int l = 0;
        int r = 17;
        int ans = -1;
        while (l <= r) {
            int m = (l + r) / 2;
            if ((int) Math.pow(3, m) <= n) {
                ans = m;
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int n = 12;
        CheckIfNumberisSumOfPower3 c = new CheckIfNumberisSumOfPower3();
        System.out.println(c.checkPowersOfThree(n));
    }

}

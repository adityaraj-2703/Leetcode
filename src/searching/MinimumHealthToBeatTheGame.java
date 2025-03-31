package searching;

public class MinimumHealthToBeatTheGame {
    public long minimumHealth(int[] damage, int armor) {
        int r = 0;
        for (int i = 0; i < damage.length; i++) {
            r += damage[i];
        }
        r += 1;
        int l = 0;
        int ans = -1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (find(m, damage, armor)) {
                ans = m;
                r = m - 1;
            } else {
                l = m + 1;
            }

        }
        return ans;
    }

    public boolean find(int m, int[] damage, int armor) {
        boolean flag = true;
        for (int i = 0; i < damage.length; i++) {
            if (m == 0) {
                if (flag) {
                    m += armor;
                    flag = false;
                } else {
                    return false;
                }
            }
            if (m < 0) {
                return false;
            }
            m -= damage[i];

        }
        if (m <= 0) {
            if (!flag) {
                return false;
            }

        }
        return true;
    }

    public static void main(String[] args) {
        int[] damage = { 2, 5, 3, 4 };
        int armor = 7;
        MinimumHealthToBeatTheGame m = new MinimumHealthToBeatTheGame();
        System.out.println(m.minimumHealth(damage, armor));
    }

}

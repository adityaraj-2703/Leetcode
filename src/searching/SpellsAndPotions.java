package searching;

import java.util.Arrays;

public class SpellsAndPotions {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int[] ans = new int[spells.length];
        for (int i = 0; i < spells.length; i++) {
            int l = 0;
            int r = potions.length - 1;
            int ind = -1;
            while (l <= r) {
                int m = (l + r) / 2;
                if ((potions[m] * spells[i]) >= success) {
                    ind = m;
                    r = m - 1;

                } else {

                    l = m + 1;

                }
            }
            if (ind == -1) {
                ans[i] = 0;
            } else {
                ans[i] = potions.length - ind;
            }

        }
        return ans;
    }

    public static void main(String[] args) {
        int[] spells = { 5, 1, 3 };
        int[] potions = { 1, 2, 3, 4, 5 };
        int success = 7;
        SpellsAndPotions s = new SpellsAndPotions();
        int[] ans = s.successfulPairs(spells, potions, success);
        for (int i = 0; i < ans.length; i++) {
            System.out.println(ans[i]);
        }
    }

}

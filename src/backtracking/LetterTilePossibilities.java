package backtracking;

public class LetterTilePossibilities {
    public int numTilePossibilities(String tiles) {
        int[] hm = new int[26];
        for (int i = 0; i < tiles.length(); i++) {
            hm[tiles.charAt(i) - 'A']++;
        }
        int sum = 0;
        for (int i = 1; i <= tiles.length(); i++) {
            sum += find(i, hm, 0);
        }
        return sum;
    }

    public int find(int i, int[] hm, int ind) {
        if (ind == i) {
            return 1;
        }
        if (ind > i) {
            return 0;
        }

        int sum = 0;
        for (int k = 0; k < 26; k++) {
            if (hm[k] > 0) {
                hm[k]--;
                sum += find(i, hm, ind + 1);
                hm[k]++;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        LetterTilePossibilities l = new LetterTilePossibilities();
        System.out.println(l.numTilePossibilities("AAB"));
    }

}

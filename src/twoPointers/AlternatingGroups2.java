package twoPointers;

public class AlternatingGroups2 {
    public int numberOfAlternatingGroups(int[] colors, int k) {
        int i = 0;
        int j = 0;
        for (int l = 1; l < k; l++) {
            if (colors[l] != colors[l - 1]) {
                j++;
            } else {
                i = j;
                j++;
            }
        }
        int count = 0;
        if (j - i + 1 == k) {
            i++;
            j++;
            count++;
        }
        while (j != i) {
            int curr = j == colors.length ? 0 : j;
            int prev = j == 0 ? colors.length - 1 : j - 1;
            if (colors[curr] != colors[prev]) {
                j++;
            } else {
                i = j;
                j++;
            }
            int gap = j > i ? j - i + 1 : colors.length - i + j + 2;
            if (gap == k) {
                count++;
            }

        }
        return count;

    }

    public static void main(String[] args) {
        int[] colors = { 0, 1, 0, 1, 0 };
        int k = 3;
        AlternatingGroups2 a = new AlternatingGroups2();
        System.out.println(a.numberOfAlternatingGroups(colors, k));
    }

}

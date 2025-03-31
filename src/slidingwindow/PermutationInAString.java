package slidingwindow;

public class PermutationInAString {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        int[] f1 = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            f1[s1.charAt(i) - 'a']++;
        }
        int[] f2 = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            f2[s2.charAt(i) - 'a']++;
        }
        int i = 0;
        int j = s1.length();
        while (j < s2.length()) {
            if (check(f1, f2)) {
                return true;
            }
            f2[s2.charAt(i) - 'a']--;

            f2[s2.charAt(j) - 'a']++;
            i++;
            j++;

        }
        if (check(f1, f2)) {
            return true;
        }
        return false;
    }

    public boolean check(int[] f1, int[] f2) {
        for (int i = 0; i < 26; i++) {
            if (f1[i] != f2[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s1 = "adc";
        String s2 = "dcda";
        PermutationInAString p = new PermutationInAString();
        System.out.println(p.checkInclusion(s1, s2));
    }

}

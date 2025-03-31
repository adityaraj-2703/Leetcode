package string;

public class GreatestCommonDivisorOfStrings {
    public String gcdOfStrings(String str1, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append(str1);
        sb.append(str2);

        int j = 1;
        while (j < sb.length()) {
            if (gcdOfStringsUtil(sb.substring(0, j), sb)) {
                return sb.substring(0, j).toString();
            }
            j++;
        }
        return "";
    }

    public boolean gcdOfStringsUtil(String temp, StringBuilder sb) {
        int i = 0;
        int j = 0;
        while (i < sb.length()) {
            if (temp.charAt(j) == sb.charAt(i)) {
                j++;
                i++;
            } else {
                return false;
            }
            if (j == temp.length()) {
                j = 0;
            }
        }
        return j == 0;
    }

    public static void main(String[] args) {
        String s1 = "ABCABC";
        String s2 = "ABC";
        GreatestCommonDivisorOfStrings g = new GreatestCommonDivisorOfStrings();
        System.out.println(g.gcdOfStrings(s1, s2));
    }

}

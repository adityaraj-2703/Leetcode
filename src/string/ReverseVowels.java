package string;

public class ReverseVowels {
    public String reverseVowels(String s) {
        int i = 0;
        int j = s.length() - 1;
        char[] c = s.toCharArray();
        while (i < j) {
            if (isVowel(c[i]) && isVowel(c[j])) {
                char temp = c[i];
                c[i] = c[j];
                c[j] = temp;
                i++;
                j--;
            } else if (isVowel(c[i])) {
                j--;
            } else {
                i++;
            }
        }
        return c.toString();
    }

    public boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' ||
                c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }

    public static void main(String[] args) {
        String a = "IceCreAm";
        ReverseVowels r = new ReverseVowels();
        System.out.println(r.reverseVowels(a));
    }

}

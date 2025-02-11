package twoPointers;

public class StringCompression {
    public int compress(char[] chars) {
        String s = "";
        int count = 1;
        for (int i = 0; i < chars.length; i++) {
            if (i + 1 < chars.length && chars[i] == chars[i + 1]) {
                count++;
            } else {
                s += chars[i];
                if (count > 1) {
                    s += count;
                }
                count = 1;
            }
        }
        for (int i = 0; i < s.length(); i++) {
            chars[i] = s.charAt(i);
        }
        return s.length();
    }

    public static void main(String[] args) {
        StringCompression s = new StringCompression();
        char[] chars = { 'a', 'a', 'b', 'b', 'c', 'c', 'c' };
        System.out.println(s.compress(chars));
    }

}

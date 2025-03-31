package string;

public class MinimumFlips {
    public int minFlips(int a, int b, int c) {
        String a1 = find(a);
        String b1 = find(b);
        String c1 = find(c);
        int count = 0;
        int i = a1.length() - 1;
        int j = b1.length() - 1;
        int k = c1.length() - 1;
        while (k >= 0) {
            if (c1.charAt(k) == '1') {

                if ((i >= 0 && a1.charAt(i) == '1') || (j >= 0 && b1.charAt(j) == '1')) {

                } else {
                    count++;
                }

            } else {
                if (i >= 0 && a1.charAt(i) == '1') {
                    count++;
                }
                if (j >= 0 && b1.charAt(j) == '1') {
                    count++;
                }

            }
            k--;
            j--;
            i--;

        }
        while (i >= 0) {
            if (a1.charAt(i) == '1')
                count++;
            i--;
        }
        while (j >= 0) {
            if (b1.charAt(j) == '1')
                count++;
            j--;
        }
        return count;
    }

    static String find(int a) {
        StringBuilder sb = new StringBuilder();
        while (a > 0) {
            if (a % 2 == 0) {
                sb.append('0');
            } else {
                sb.append('1');
            }
            a /= 2;
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        int a = 10;
        int b = 9;
        int c = 1;
        MinimumFlips m = new MinimumFlips();
        System.out.println(m.minFlips(a, b, c));
    }

}

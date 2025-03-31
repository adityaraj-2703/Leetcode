package string;

public class MultiplyTwoString {
    public String multiply(String num1, String num2) {
        if (num2.length() > num1.length()) {
            return multiply(num2, num1);
        }
        StringBuilder ans = new StringBuilder();
        int nz = 0;
        for (int i = num2.length() - 1; i >= 0; i--) {
            int c = num2.charAt(i) - '0';
            int carry = 0;
            StringBuilder sb = new StringBuilder();
            for (int k = 0; k < nz; k++) {
                sb.append('0');
            }
            nz++;
            for (int j = num1.length() - 1; j >= 0; j--) {
                int temp = c * (num1.charAt(j) - '0');
                temp += carry;
                if (temp > 10) {
                    carry = temp / 10;
                } else {
                    carry = 0;
                }
                temp = temp % 10;
                sb.append(temp);
            }
            if (carry != 0) {
                sb.append(carry);
            }
            sb = sb.reverse();
            if (ans.length() == 0) {
                ans = sb;
                continue;
            }
            int inda = ans.length() - 1;
            int inds = sb.length() - 1;
            int carry1 = 0;
            StringBuilder temp = new StringBuilder();
            while (inda >= 0 || inds >= 0) {
                int tot = 0;
                tot += carry1;
                if (inda >= 0) {
                    tot += ans.charAt(inda) - '0';
                    inda--;
                }
                if (inds >= 0) {
                    tot += sb.charAt(inds) - '0';
                    inds--;
                }
                if (tot > 9) {
                    carry1 = tot / 10;
                } else {
                    carry1 = 0;
                }
                tot = tot % 10;
                temp.append(tot);
            }
            if (carry1 != 0) {
                temp.append(carry);
            }
            ans = temp.reverse();

        }
        return ans.toString();

    }

    public static void main(String[] args) {
        String a = "123";
        String b = "999";
        MultiplyTwoString m = new MultiplyTwoString();
        System.out.println(m.multiply(a, b));
    }

}

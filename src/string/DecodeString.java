package string;

import java.util.Stack;

public class DecodeString {
    public String decodeString(String s) {
        Stack<String> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if ((s.charAt(i) >= '0' && s.charAt(i) <= '9')) {
                int temp = 0;
                int ind = i;
                while (s.charAt(ind) >= '0' && s.charAt(ind) <= '9') {
                    temp = temp * 10 + (s.charAt(ind) - '0');
                    ind++;
                }
                i = ind - 1;
                st.push(temp + "");
            } else if ((s.charAt(i) >= 'a' && s.charAt(i) <= 'z') || s.charAt(i) == '[') {
                st.push(s.charAt(i) + "");

            } else {
                StringBuilder sb = new StringBuilder();
                while (!st.isEmpty() && !st.peek().equals("[")) {
                    sb.append(st.pop());
                }
                st.pop();
                int count = Integer.parseInt(st.pop());
                StringBuilder sb1 = new StringBuilder();
                for (int j = 0; j < count; j++) {
                    sb1.append(sb);
                }
                st.push(sb1.toString());

            }
        }
        StringBuilder ans = new StringBuilder();
        while (!st.isEmpty()) {
            ans.append(st.pop());
        }
        return ans.reverse().toString();
    }

    public static void main(String[] args) {
        String str = "3[a]2[bc]";
        DecodeString d = new DecodeString();
        System.out.println(d.decodeString(str));
    }

}

package dp;

import java.util.Stack;

public class LongestValidParentheses {
    public int longestValidParentheses(String s) {
        return longestValidParenthesesUtil(s, 0, s.length() - 1);
    }

    public int longestValidParenthesesUtil(String s, int l, int r) {
        if (l >= r) {
            return 0;
        }
        boolean flag = validateParentheses(s, l, r);
        if (flag) {
            return r - l + 1;
        }
        return Math.max(longestValidParenthesesUtil(s, l + 1, r), longestValidParenthesesUtil(s, l, r - 1));
    }

    public boolean validateParentheses(String s, int l, int r) {
        Stack<Character> st = new Stack<>();
        for (int i = l; i <= r; i++) {
            if (s.charAt(i) == '(') {
                st.push(s.charAt(i));
            } else {
                if (st.isEmpty() || st.peek() != '(') {
                    return false;
                } else {
                    st.pop();
                }
            }
        }
        return st.isEmpty();
    }

    public static void main(String[] args) {
        String s = "(()";
        LongestValidParentheses l = new LongestValidParentheses();
        System.out.println(l.longestValidParentheses(s));
    }

}

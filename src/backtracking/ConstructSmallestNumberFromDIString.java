package backtracking;

import java.util.HashSet;
import java.util.Set;

public class ConstructSmallestNumberFromDIString {
    public String smallestNumber(String pattern) {
        // int t = 0;

        // for(int i=0;i<pattern.length();i++){
        // if(pattern.charAt(i)=='I'){
        // t++;
        // }
        // else{
        // t--;
        // }
        // }
        // int x = 1+t;
        // StringBuilder sb = new StringBuilder();
        // sb.append(x);
        // for(int i=0;i<pattern.length();i++){
        // if(pattern.charAt(i)=='I'){
        // x += 1;
        // sb.append(x);
        // }
        // else{
        // x -= 1;
        // sb.append(x);
        // }
        // }
        // return sb.toString();
        StringBuilder sb = new StringBuilder();
        return smallestNumberUtil(pattern, pattern.length() - 1, sb, 0);
    }

    public String smallestNumberUtil(String pattern, int index, StringBuilder sb, int last) {
        if (sb.length() > 0 && sb.charAt(sb.length() - 1) <= '0') {
            return null;
        }
        if (index == -1) {
            return sb.toString();
        }
        if (pattern.charAt(index) == 'I') {
            for (int i = last + 1; i <= 9; i++) {
                char c1 = (char) (i + '0');
                if (sb.indexOf(c1 + "") != -1) {
                    continue;
                }
                sb.append(i);
                if (smallestNumberUtil(pattern, index - 1, sb, i) != null) {
                    return sb.toString();
                }
                sb.deleteCharAt(sb.length() - 1);
            }

        } else {

            for (int i = 1; i <= 9; i--) {
                char c1 = (char) (i + '0');
                if (sb.indexOf(c1 + "") != -1) {
                    continue;
                }
                sb.append(i);
                if (smallestNumberUtil(pattern, index - 1, sb, i) != null) {
                    return sb.toString();
                }
                sb.deleteCharAt(sb.length() - 1);
            }

        }
        return null;
    }

    public static void main(String[] args) {
        ConstructSmallestNumberFromDIString c = new ConstructSmallestNumberFromDIString();
        System.out.println(c.smallestNumber("IIIDIDDD"));
    }

}

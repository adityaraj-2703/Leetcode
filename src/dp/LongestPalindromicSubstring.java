package dp;

public class LongestPalindromicSubstring {
    public static String longestPalindrome(String s) {
        return findlongestPalindrome(s,0,s.length()-1);
    }
    public static String findlongestPalindrome(String s,int i,int j){
        if(i>j){
            return "";
        }
        if(i==j){
            return s.charAt(i) + "";
        }
        int st = i;
        int en = j;
        while(st<en){
            if(s.charAt(st)!=s.charAt(en)){
                break;
            }
            else{
                st++;
                en--;
            }
        }
        String a = "";
        String b = "";
        String c = "";
        if(st>=en){
            c = s.substring(i,j+1);
        }
        a = findlongestPalindrome(s,i+1,j);  
        b = findlongestPalindrome(s,i,j-1);
        if(a.length() >= b.length() && a.length() >= c.length()){
            return a;
        }
        else if(b.length() >= a.length() && b.length() >= c.length()){
            return b;
        }
        else{
            return c;
        }

    }
}
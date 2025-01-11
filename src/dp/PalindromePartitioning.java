package dp;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
    public static List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        List<String> temp =new ArrayList<>();
        find(ans,temp,s,0,s.length()-1);
        return ans;
    }
    public static void find(List<List<String>> ans,List<String> temp,String s,int i,int j){
        if(i>j){
            ans.add(temp);
            return; 
        }
        for(int k=i;k<j;k++){
            if(isPalindrome(s,i,k)){
                temp.add(s.substring(i,k+1));
                find(ans,temp,s,k+1,j);
            }
        }
    }
    public static boolean isPalindrome(String s,int i,int j){
        while(i<j){
            if(s.charAt(i)!=s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}

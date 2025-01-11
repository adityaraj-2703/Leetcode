package hash;

import java.util.HashMap;
import java.util.Map;

public class MinWindow {
    public String minWindow(String s, String t) {
        Map<Character,Integer> hm = new HashMap<>();
        if(s == null || s.length() < t.length() || s.length() == 0){
            return "";
        }
        for(int i=0;i<t.length();i++){
            hm.put(t.charAt(i),hm.getOrDefault(t.charAt(i),0)+1);
        }
        int i = 0;
        int j = 0;
        boolean flag = false;
        Map<Character,Integer> hm1 = new HashMap<>();
        String temp = s.substring(i,j+1);
        
        while(j<s.length()){
            temp = s.substring(i,j+1);
            hm1.put(s.charAt(j),hm1.getOrDefault(s.charAt(j),0)+1);
            if(check(hm1,hm)){
                flag = true;
                break;
            }
            else{
                j++;
            }
        }
        if(flag == false){
            return "";
        }
        int min = j-i+1;
        String ans = s.substring(i,j+1);
        while(i<=j && j<s.length()){
            temp = s.substring(i,j+1);
            if(check(hm1,hm)){
                if(min > j-i+1){
                    min = j-i+1;
                    ans = s.substring(i,j+1);
                }
                int t1 = hm1.getOrDefault(s.charAt(i),-1);
                if(t1==1){
                    hm1.remove(s.charAt(i));
                }
                else{
                    hm1.put(s.charAt(i),t1-1);
                }
                i++;
            }
            else{
                j++;
                if(j==s.length()){
                    break;
                }
                hm1.put(s.charAt(j),hm1.getOrDefault(s.charAt(j),0)+1);
            }
        }
        return ans;
    }
    static boolean check(Map<Character,Integer> hm1,Map<Character,Integer> hm){
        for(Map.Entry<Character,Integer> m : hm.entrySet()){
            int l = hm1.getOrDefault(m.getKey(),-1);
            if(l==-1){
                return false;
            }
            else if(l < m.getValue()){
                return false;
            }
        }
        return true;
    }

}

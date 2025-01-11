package hash;

import java.util.ArrayList;
import java.util.List;

public class GroupAnagrams {
     public List<List<String>> groupAnagrams(String[] strs) {
        boolean[] f = new boolean[strs.length];
       
        List<List<String>> ans = new ArrayList<>();
        for(int i=0;i<strs.length;i++){
            if(f[i]==true){
                continue;
            }
            List<String> ans1 = new ArrayList<>();
            ans1.add(strs[i]);
            int[] temp = new int[26];
            for(int c=0;c<strs[i].length();c++){
                temp[strs[i].charAt(c) - 97]++;
            }
            
            for(int j=i+1;j<strs.length;j++){
                int[] temp1 = new int[26];
                for(int d=0;d<strs[j].length();d++){
                    temp1[strs[j].charAt(d) - 97]++;
                }
                boolean flag = true;
                for(int z=0;z<temp.length;z++){
                    if(temp[z]!=temp1[z]){
                        flag = false;
                        break;
                    }
                }
                if(flag){
                    ans1.add(strs[j]);
                    f[j] = true;
                }
            }
            ans.add(ans1);
            
        }
        return ans;
    }
}

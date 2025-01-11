package hash;

import java.util.HashSet;
import java.util.Set;

public class DividePlayers {
    public long dividePlayers(int[] skill) {
        long sum = 0;
        int n = skill.length;
        for(int i=0;i<n;i++){
            sum += skill[i];
        }
        sum = sum * 2 / n;
        Set<Integer> hs = new HashSet<>();
        long ans = 0;
        for(int i = 0;i<skill.length;i++){
            if(hs.contains((int)sum - skill[i])){
                ans += skill[i]*(sum-skill[i]);
            }
            else{
                hs.add(skill[i]);
            }
        }
        if(hs.size()!= n/2){
            return -1;
        }
        return ans;
        
    }
}
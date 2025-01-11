package hash;

import java.util.HashMap;
import java.util.Map;

public class PairSum {
    public int numberOfWays(int[] arr, int k) {
    // Write your code here
    Map<Integer,Integer> hm = new HashMap<>();
    for(int i=0;i<arr.length;i++){
      hm.put(arr[i],hm.getOrDefault(arr[i],0)+1);
    }
    int sum=0;
    for(int i=0;i<arr.length;i++){
      int l = hm.getOrDefault(k-arr[i],-1);
      if(l!=-1){
        if(arr[i] == k-arr[i]){
          int a = hm.get(arr[i]);
          
          if(a==2){
            sum++;
          }
          else if(a==1){
            continue;
          }
          else{
            sum += l*(l-1)/2;
          }
        }
        else{
          int a = hm.get(arr[i]);
          int b = hm.get(k-arr[i]);
          sum += a*b;
        }
      }
      
    }
    return sum;
  }
}

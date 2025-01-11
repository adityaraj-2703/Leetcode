package searching;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;


public class MostBeautifulItemforEachQuery {
    public int[] maximumBeauty(int[][] items, int[] queries) {
        Map<Integer,Integer> hm = new HashMap<>();
        Pair[] p = new Pair[queries.length];
        for(int i=0;i<queries.length;i++){
            p[i] = new Pair(queries[i],i);
        }
        Arrays.sort(items, new Comparator<int[]>() {
            public int compare(int[] a,int[] b){
                return a[0] - b[0];
            }
        });
        Arrays.sort(p, new Comparator<Pair>() {
            public int compare(Pair a,Pair b){
                return a.val - b.val;
            }
        });
        int max = 0;
        int[] ans = new int[queries.length];
        int j=0;
        for(int i=0;i<p.length;i++){
            while(j<items.length && items[j][0] <= p[i].val){
                max = Math.max(items[j][1],max);
                j++;
            }
            System.out.println(p[i].ind);
            ans[p[i].ind] = max;
        }
        return ans;
    }
}
class Pair{
    int val;
    int ind;
    Pair(int val,int ind){
        this.ind = ind;
        this.val = val;
    }

}

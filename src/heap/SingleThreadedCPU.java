package heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class SingleThreadedCPU {
    public int[] getOrder(int[][] tasks) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            public int compare(int[] a,int[] b){
                if(a[1]!=b[1]){
                    return a[1]-b[1];
                }
                return a[2]-b[2];
            }
        });
        Arrays.sort(tasks,new Comparator<int[]>() {
            public int compare(int[] a,int[] b){
                if(a[0]!=b[0]){
                    return a[0]-b[0];
                }
                else{
                    return a[1]-b[1];
                }
            }
        });

        return null;
    }
}

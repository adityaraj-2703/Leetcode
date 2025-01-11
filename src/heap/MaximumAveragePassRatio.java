package heap;

import java.util.*;

public class MaximumAveragePassRatio {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        if(classes.length==1){
            return (double)classes[0][0]+extraStudents / classes[0][1]+extraStudents;
        }
        PriorityQueue<PairMA> pq = new PriorityQueue<>(new Comparator<PairMA>(){
            public int compare(PairMA p1,PairMA p2){
                double a1 = (double)(p1.pass+1)/(double)(p1.total+1) - (double)p1.pass/(double)p1.total;
                System.out.println(a1);
                double a2 = (double)(p2.pass+1)/(double)(p2.total+1) - (double)p2.pass/(double)p2.total;
                System.out.println(a2);
                return Double.compare(a2, a1);
            }
        });
        for(int i=0;i<classes.length;i++){
            pq.add(new PairMA(classes[i][0],classes[i][1]));
        }
        for(int i=0;i<extraStudents;i++){
            PairMA p = pq.poll();
            pq.add(new PairMA(p.pass+1,p.total+1));
        }
        double sum = 0;
        while(!pq.isEmpty()){
            PairMA p = pq.poll();
            sum += (double)p.pass / (double)p.total;
        }
        return sum/classes.length;
    }
    class PairMA{
        int pass;
        int total;
        PairMA(int pass,int total){
            this.pass = pass;
            this.total = total;
        }
    }
}

package greedy;

public class MergeTripletsToFormTripletTarget {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        int ind = 0;
        for (int i = 0; i < 3; i++) {
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            for (int j = 0; j < triplets.length; j++) {
                System.out.println(triplets[j][i]);
                if (triplets[j][i] <= target[ind]) {
                    max = Math.max(triplets[j][i], max);
                }
            }
            System.out.println(min + " " + max);
            if (max == target[ind]) {
                ind++;
                continue;
            } else {
                return false;
            }

        }
        return true;
    }

    public static void main(String[] args) {
        int[][] triplets = { { 2, 5, 3 }, { 1, 8, 4 }, { 1, 7, 5 } };
        int[] target = { 2, 7, 5 };
        MergeTripletsToFormTripletTarget m = new MergeTripletsToFormTripletTarget();
        System.out.println(m.mergeTriplets(triplets, target));
    }

}

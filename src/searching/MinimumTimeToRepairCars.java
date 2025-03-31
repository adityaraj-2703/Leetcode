package searching;

public class MinimumTimeToRepairCars {
    public long repairCars(int[] ranks, int cars) {
        long min = Long.MAX_VALUE;
        long max = Long.MIN_VALUE;
        for (int i = 0; i < ranks.length; i++) {
            min = Math.min(ranks[i], min);
            max = Math.max(ranks[i], max);
        }
        long l = 1;
        long r = max * cars * cars;
        long ans = -1;
        while (l <= r) {
            long m = l + (r - l) / 2;
            if (check(m, min, max, cars)) {
                ans = m;
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return ans;
    }

    public boolean check(long m, long a, long b, int cars) {
        for (int i = 1; i < cars; i++) {
            long sum1 = a * i * i;
            long sum2 = b * (cars - i) * (cars - i);
            if (sum1 <= m && sum2 <= m) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        MinimumTimeToRepairCars m = new MinimumTimeToRepairCars();
        int[] r = { 4, 2, 3, 1 };
        int cars = 10;
        System.out.println(m.repairCars(r, cars));
    }

}

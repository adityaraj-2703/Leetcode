package greedy;

public class MinumumAdditionToMakeIntegerBeautiful {
    public long makeIntegerBeautiful(long n, int target) {
        long sum = 0;
        long num = n;
        int count = 0;
        while (num > 0) {
            long rem = num % 10;
            count++;
            num = num / 10;
            sum += rem;
        }
        if (sum < target) {
            return 0;
        }
        long rev = 0;
        num = n;
        for (int i = 1; i <= count; i++) {
            long rem = num % (int) Math.pow(10, i);
            long t = (int) Math.pow(10, i) - rem;
            if (findSum(t + n) <= target) {
                return t;
            }

        }
        return -1;
    }

    public long findSum(long n) {
        long num = n;
        long sum = 0;
        while (num > 0) {
            long rem = num % 10;
            num = num / 10;
            sum += rem;
        }
        return sum;
    }

    public static void main(String[] args) {
        MinumumAdditionToMakeIntegerBeautiful m = new MinumumAdditionToMakeIntegerBeautiful();
        long t = 6068060;
        System.out.println(m.makeIntegerBeautiful(6068060, 3));
    }
}

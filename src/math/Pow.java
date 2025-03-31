package math;

public class Pow {
    public double myPow(double x, int n) {
        boolean neg = n < 0 ? true : false;
        n = Math.abs(n);
        double temp = 1;
        for (int i = 0; i < n; i++) {
            temp *= x;
        }
        if (neg) {
            return 1 / temp;
        }
        return temp;
    }

    public static void main(String[] args) {
        double x = 2.0000;
        int n = -3;
        Pow p = new Pow();
        System.out.println(p.myPow(x, n));
    }

}

package company.bloomberg.all.q0;

public class Q50 {
    public double myPow(double x, int n) {
        long N = (long) n;
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }
        return helper(x, N);
    }

    private double helper(double x, long n) {
        if (n == 0) return 1;
        if (n == 1) return x;
        if (n % 2 == 0) {
            return helper(x * x, n / 2);
        } else {
            return helper(x * x, n / 2) * x;
        }
    }
}

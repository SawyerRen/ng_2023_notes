package company.bloomberg.vo;

public class Q50 {
    public double myPow(double x, int n) {
        long nl = (long) n;
        if (nl < 0) {
            x = 1 / x;
            nl = -nl;
        }
        return helper(x, nl);
    }

    private double helper(double x, long n) {
        if (n == 0) return 1;
        if (n == 1) return x;
        if (n % 2 == 0) {
            return helper(x * x, n / 2);
        } else {
            return x * helper(x * x, n / 2);
        }
    }
}

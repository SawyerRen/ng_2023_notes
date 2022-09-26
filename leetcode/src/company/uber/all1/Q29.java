package company.uber.all1;

public class Q29 {
    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
        boolean negative = false;
        if ((dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0)) negative = true;
        int absDividend = Math.abs(dividend);
        int absDivisor = Math.abs(divisor);
        int res = 0;
        while (absDividend - absDivisor >= 0) {
            int temp = absDivisor;
            int count = 1;
            while (absDividend - (temp << 1) >= 0) {
                temp <<= 1;
                count <<= 1;
            }
            absDividend -= temp;
            res += count;
        }
        if (negative) return -res;
        return res;
    }
}

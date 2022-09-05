package company.uber.q1200;

public class Q1281 {
    public int subtractProductAndSum(int n) {
        int product = 1, sum = 0;
        while (n != 0) {
            int tail = n % 10;
            product *= tail;
            sum += tail;
            n /= 10;
        }
        return product - sum;
    }
}

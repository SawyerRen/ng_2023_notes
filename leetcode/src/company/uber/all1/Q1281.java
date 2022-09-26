package company.uber.all1;

public class Q1281 {
    public int subtractProductAndSum(int n) {
        int sum = 0, product = 1;
        while (n != 0) {
            int tail = n % 10;
            sum += tail;
            product *= tail;
            n /= 10;
        }
        return product - sum;
    }
}

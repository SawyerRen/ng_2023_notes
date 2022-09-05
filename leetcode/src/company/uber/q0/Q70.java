package company.uber.q0;

public class Q70 {
    public int climbStairs(int n) {
        if (n <= 2) return n;
        int preOne = 2, preTwo = 1;
        int res = 0;
        for (int i = 3; i <= n; i++) {
            res = preOne + preTwo;
            preTwo = preOne;
            preOne = res;
        }
        return res;
    }
}

package company.bloomberg.r2;

public class Q779 {
    public int kthGrammar(int n, int k) {
        if (n == 1) return 0;
        int pre = kthGrammar(n - 1, (k + 1) / 2);
        if (pre == 1) {
            if (k % 2 == 0) return 0;
            else return 1;
        } else {
            if (k % 2 == 0) return 1;
            return 0;
        }
    }
}

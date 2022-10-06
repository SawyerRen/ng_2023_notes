package company.bloomberg.all.q300;

public class Q338 {
    public int[] countBits(int n) {
        int[] res = new int[n + 1];
        res[0] = 0;
        for (int i = 0; i <= n; i++) {
            if (i % 2 == 0) {
                res[i] = res[i >> 1];
            } else {
                res[i] = res[i - 1] + 1;
            }
        }
        return res;
    }
}

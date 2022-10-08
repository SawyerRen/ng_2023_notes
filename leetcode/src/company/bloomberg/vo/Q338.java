package company.bloomberg.vo;

public class Q338 {
    public int[] countBits(int n) {
        if (n == 0) return new int[1];
        int[] res = new int[n + 1];
        res[0] = 0;
        res[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            if (i % 2 == 0) {
                res[i] = res[i / 2];
            } else {
                res[i] = res[i - 1] + 1;
            }
        }
        return res;
    }
}

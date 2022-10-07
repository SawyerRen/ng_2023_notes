package company.bloomberg.vo;

import java.util.HashMap;
import java.util.Map;

public class Q1553 {
    Map<Integer, Integer> memo = new HashMap<>();

    public int minDays(int n) {
        if (n == 0) return 0;
        if (memo.containsKey(n)) return memo.get(n);
        int res = minDays(n - 1) + 1;
        if (n % 2 == 0) {
            res = Math.min(res, minDays(n / 2) + 1);
        }
        if (n % 3 == 0) {
            res = Math.min(res, minDays(n / 3) + 1);
        }
        memo.put(n, res);
        return res;
    }
}

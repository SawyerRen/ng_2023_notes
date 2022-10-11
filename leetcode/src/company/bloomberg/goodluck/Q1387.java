package company.bloomberg.goodluck;

import java.util.*;

public class Q1387 {
    public int getKth(int lo, int hi, int k) {
        List<Integer> list = new ArrayList<>();
        for (int i = lo; i < hi + 1; i++) {
            list.add(i);
        }
        list.sort((a, b) -> helper(a) - helper(b));
        return list.get(k - 1);
    }

    Map<Integer, Integer> map = new HashMap<>();

    private int helper(int n) {
        if (n == 1) return 0;
        if (map.containsKey(n)) return map.get(n);
        int res;
        if (n % 2 == 0) {
            res = helper(n / 2) + 1;
        } else {
            res = helper(n * 3 + 1) + 1;
        }
        map.put(n, res);
        return res;
    }
}

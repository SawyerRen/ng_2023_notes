package company.bloomberg.vo;

import java.util.*;

public class Q1387 {
    public int getKth(int lo, int hi, int k) {
        List<Integer> list = new ArrayList<>();
        for (int i = lo; i < hi + 1; i++) {
            list.add(i);
        }
        list.sort((a, b) -> getPower(a) - getPower(b));
        return list.get(k - 1);
    }

    Map<Integer, Integer> map = new HashMap<>();

    int getPower(int n) {
        if (n == 1) return 0;
        if (map.containsKey(n)) return map.get(n);
        if (n % 2 == 0) {
            map.put(n, getPower(n / 2) + 1);
        } else {
            map.put(n, getPower(3 * n + 1) + 1);
        }
        return map.get(n);
    }
}

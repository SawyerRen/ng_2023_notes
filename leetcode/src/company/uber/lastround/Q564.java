package company.uber.lastround;

import java.util.ArrayList;
import java.util.List;

public class Q564 {
    public String nearestPalindromic(String n) {
        int len = n.length();
        boolean even = len % 2 == 0;
        long half = even ? Long.parseLong(n.substring(0, len / 2)) : Long.parseLong(n.substring(0, len / 2 + 1));
        List<Long> list = new ArrayList<>();
        list.add(helper(half, even));
        list.add(helper(half + 1, even));
        list.add(helper(half - 1, even));
        list.add((long) Math.pow(10, len - 1) - 1);
        list.add((long) Math.pow(10, len) + 1);
        long nl = Long.parseLong(n);
        long res = 0, minDiff = Long.MAX_VALUE;
        for (Long v : list) {
            if (v == nl) continue;
            if (Math.abs(v - nl) < minDiff) {
                minDiff = Math.abs(v - nl);
                res = v;
            } else if (Math.abs(v - nl) == minDiff && v < res) {
                res = v;
            }
        }
        return String.valueOf(res);
    }

    private Long helper(long half, boolean even) {
        long temp = half;
        if (!even) temp /= 10;
        while (temp != 0) {
            half = half * 10 + temp % 10;
            temp /= 10;
        }
        return half;
    }
}

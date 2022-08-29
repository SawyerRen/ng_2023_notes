package company.uber.q500;

import java.util.ArrayList;
import java.util.List;

public class Q564 {
    public String nearestPalindromic(String n) {
        int len = n.length();
        boolean even = len % 2 == 0;
        long half = even ? Long.parseLong(n.substring(0, len / 2)) : Long.parseLong(n.substring(0, len / 2 + 1));
        List<Long> list = new ArrayList<>();
        list.add(getPal(half, even));
        list.add(getPal(half + 1, even));
        list.add(getPal(half - 1, even));
        list.add((long) Math.pow(10, len) + 1);
        list.add((long) Math.pow(10, len - 1) - 1);
        long res = 0, minDiff = Long.MAX_VALUE;
        long nl = Long.parseLong(n);
        for (Long val : list) {
            if (val == nl) continue;
            if (minDiff > Math.abs(val - nl)) {
                res = val;
                minDiff = Math.abs(val - nl);
            } else if (minDiff == Math.abs(val - nl) && val < res) {
                res = val;
            }
        }
        return String.valueOf(res);
    }

    private Long getPal(long half, boolean even) {
        long temp = half;
        if (!even) temp /= 10;
        while (temp != 0) {
            half = half * 10 + temp % 10;
            temp /= 10;
        }
        return half;
    }
}

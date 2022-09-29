package company.uber.goodluck;

import java.util.ArrayList;
import java.util.List;

public class Q564 {
    public String nearestPalindromic(String n) {
        int len = n.length();
        boolean even = len % 2 == 0;
        String halfStr = even ? n.substring(0, len / 2) : n.substring(0, len / 2 + 1);
        long half = Long.parseLong(halfStr);
        List<Long> list = new ArrayList<>();
        list.add(getPal(half, even));
        list.add(getPal(half + 1, even));
        list.add(getPal(half - 1, even));
        list.add((long) Math.pow(10, len - 1) - 1);
        list.add((long) Math.pow(10, len) + 1);
        long nl = Long.parseLong(n);
        long minDiff = Long.MAX_VALUE;
        long res = 0;
        for (Long v : list) {
            if (v == nl) continue;
            if (Math.abs(v - nl) < minDiff) {
                minDiff = Math.abs(v - nl);
                res = v;
            } else if (Math.abs(v - nl) == minDiff && res > v) {
                res = v;
            }
        }
        return String.valueOf(res);
    }

    private Long getPal(long n, boolean even) {
        long temp = n;
        if (!even) temp /= 10;
        while (temp != 0) {
            n = n * 10 + temp % 10;
            temp /= 10;
        }
        return n;
    }
}

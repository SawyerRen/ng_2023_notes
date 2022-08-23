package company.uber.q500;

import java.util.ArrayList;
import java.util.List;

public class Q564 {
    public String nearestPalindromic(String n) {
        int len = n.length();
        boolean even = len % 2 == 0;
        String halfStr = even ? n.substring(0, len / 2) : n.substring(0, len / 2 + 1);
        List<Long> list = new ArrayList<>();
        long halfVal = Long.parseLong(halfStr);
        list.add(buildPal(halfVal, even));
        list.add(buildPal(halfVal + 1, even));
        list.add(buildPal(halfVal - 1, even));
        list.add((long) Math.pow(10, len - 1) - 1);
        list.add((long) Math.pow(10, len) + 1);
        long res = 0, minDiff = Long.MAX_VALUE;
        long nl = Long.parseLong(n);
        for (Long val : list) {
            if (val == nl) continue;
            if (minDiff > Math.abs(val - nl)) {
                minDiff = Math.abs(val - nl);
                res = val;
            } else if (val < res && minDiff == Math.abs(val - nl)) {
                res = val;
            }
        }
        return String.valueOf(res);
    }

    private Long buildPal(long n, boolean even) {
        long temp = n;
        if (!even) temp /= 10;
        while (temp != 0) {
            n = n * 10 + temp % 10;
            temp /= 10;
        }
        return n;
    }
}

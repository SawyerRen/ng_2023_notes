package company.uber.q500;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Q564 {
    public String nearestPalindromic(String n) {
        int len = n.length();
        boolean even = len % 2 == 0;
        String firstHalf = even ? n.substring(0, len / 2) : n.substring(0, len / 2 + 1);
        List<Long> list = new ArrayList<>();
        long half = Long.parseLong(firstHalf);
        list.add(getPal(half + 1, even));
        list.add(getPal(half - 1, even));
        list.add(getPal(half, even));
        list.add((long) Math.pow(10, len) + 1);
        list.add((long) Math.pow(10, len - 1) - 1);

        long minDiff = Long.MAX_VALUE, res = 0;
        long nl = Long.parseLong(n);
        for (Long val : list) {
            if (nl == val) continue;
            if (Math.abs(val - nl) < minDiff) {
                minDiff = Math.abs(val - nl);
                res = val;
            } else if (Math.abs(val - nl) == minDiff && val < res) {
                res = val;
            }
        }
        return String.valueOf(res);
    }

    private Long getPal(long half, boolean even) {
        long res = half;
        if (!even) half /= 10;
        while (half != 0) {
            res = res * 10 + half % 10;
            half /= 10;
        }
        return res;
    }
}

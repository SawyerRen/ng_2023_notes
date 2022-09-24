package company.uber.all1;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Q564 {
    public String nearestPalindromic(String n) {
        int len = n.length();
        boolean even = len % 2 == 0;
        String halfStr = even ? n.substring(0, len / 2) : n.substring(0, len / 2 + 1);
        long half = Long.parseLong(halfStr);
        List<Long> list = new ArrayList<>();
        list.add(getPal(half + 1, even));
        list.add(getPal(half, even));
        list.add(getPal(half - 1, even));
        list.add((long) Math.pow(10, len) + 1);
        list.add((long) Math.pow(10, len - 1) - 1);
        long nl = Long.parseLong(n);
        long res = 0, minDiff = Long.MAX_VALUE;
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

    private Long getPal(long l, boolean even) {
        long temp = l;
        if (!even) temp /= 10;
        while (temp != 0) {
            l = l * 10 + temp % 10;
            temp /= 10;
        }
        return l;
    }
}

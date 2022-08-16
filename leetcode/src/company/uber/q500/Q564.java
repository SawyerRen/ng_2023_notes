package company.uber.q500;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Q564 {
    public String nearestPalindromic(String n) {
        int len = n.length();
        boolean even = len % 2 == 0;
        long left = 0;
        if (even) {
            left = Long.parseLong(n.substring(0, len / 2));
        } else {
            left = Long.parseLong(n.substring(0, len / 2 + 1));
        }
        List<Long> candidates = new ArrayList<>();
        candidates.add(getPal(left, even));
        candidates.add(getPal(left - 1, even));
        candidates.add(getPal(left + 1, even));
        candidates.add((long) Math.pow(10, len - 1) - 1); // for 10, 100, 1000, 11, 101, 1001
        candidates.add((long) Math.pow(10, len) + 1); // for 99, 999, 9999

        long minDiff = Long.MAX_VALUE, res = 0, nl = Long.parseLong(n);
        for (Long candidate : candidates) {
            if (candidate == nl) continue;
            if (Math.abs(nl - candidate) < minDiff) {
                minDiff = Math.abs(nl - candidate);
                res = candidate;
            } else if (Math.abs(nl - candidate) == minDiff) {
                res = Math.min(res, candidate);
            }
        }
        return String.valueOf(res);
    }

    private Long getPal(long left, boolean even) {
        long res = left;
        if (!even) left /= 10;
        while (left != 0) {
            res = res * 10 + left % 10;
            left /= 10;
        }
        return res;
    }
}

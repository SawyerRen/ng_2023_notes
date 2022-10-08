package company.bloomberg.vo;

import java.util.HashSet;
import java.util.Set;

public class Q202 {
    Set<Integer> set = new HashSet<>();

    public boolean isHappy(int n) {
        if (n == 1) return true;
        int next = 0;
        while (n != 0) {
            int t = n % 10;
            next += t * t;
            n /= 10;
        }
        if (set.contains(next)) return false;
        set.add(next);
        return isHappy(next);
    }
}

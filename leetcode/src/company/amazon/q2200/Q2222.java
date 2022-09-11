package company.amazon.q2200;

import java.util.HashMap;
import java.util.Map;

public class Q2222 {
    public long numberOfWays(String s) {
        long total1 = 0, total0 = 0;
        for (char c : s.toCharArray()) {
            if (c == '1') total1++;
            else total0++;
        }
        long left1 = 0, left0 = 0;
        long res = 0;
        for (char c : s.toCharArray()) {
            if (c == '1') {
                res += left0 * (total0 - left0);
                left1++;
            } else {
                res += left1 * (total1 - left1);
                left0++;
            }
        }
        return res;
    }
}

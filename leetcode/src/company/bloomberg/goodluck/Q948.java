package company.bloomberg.goodluck;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Q948 {
    public int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);
        int cur = 0, max = 0;
        int i = 0, j = tokens.length - 1;
        while (i <= j) {
            if (power >= tokens[i]) {
                power -= tokens[i];
                cur++;
                max = Math.max(cur, max);
                i++;
            } else {
                if (cur <= 0) break;
                power += tokens[j];
                cur--;
                j--;
            }
        }
        return max;
    }
}

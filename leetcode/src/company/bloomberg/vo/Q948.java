package company.bloomberg.vo;

import java.util.Arrays;

public class Q948 {
    public int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);
        int res = 0, cur = 0;
        int i = 0, j = tokens.length - 1;
        while (i <= j) {
            if (power >= tokens[i]) {
                cur++;
                res = Math.max(res, cur);
                power -= tokens[i];
                i++;
            } else if (cur > 0) {
                power += tokens[j];
                cur--;
                j--;
            } else {
                break;
            }
        }
        return res;
    }
}

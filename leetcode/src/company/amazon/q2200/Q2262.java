package company.amazon.q2200;

import java.util.Arrays;

public class Q2262 {
    public long appealSum(String s) {
        long res = 0;
        char[] chars = s.toCharArray();
        int[] pos = new int[26];
        Arrays.fill(pos, -1);
        for (int i = 0; i < chars.length; i++) {
            int preIndex = pos[chars[i] - 'a'];
            res += (long) (i - preIndex) * (s.length() - i);
            pos[chars[i] - 'a'] = i;
        }
        return res;
    }
}

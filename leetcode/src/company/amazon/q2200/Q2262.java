package company.amazon.q2200;

import java.util.Arrays;

public class Q2262 {
    public long appealSum(String s) {
        long res = 0;
        int[] lastOccur = new int[26];
        Arrays.fill(lastOccur, -1);
        for (int i = 0; i < s.length(); i++) {
            int preIndex = lastOccur[s.charAt(i) - 'a'];
            res += (long) (i - preIndex) * (s.length() - i);
            lastOccur[s.charAt(i) - 'a'] = i;
        }
        return res;
    }
}

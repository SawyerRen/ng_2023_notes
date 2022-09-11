package company.amazon.q2200;

import java.util.Arrays;

public class Q2268 {
    public int minimumKeypresses(String s) {
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        Arrays.sort(count);
        int index = 0;
        int res = 0;
        for (int i = count.length - 1; i >= 0; i--) {
            if (index < 9) res += count[i];
            else if (index < 18) res += count[i] * 2;
            else res += count[i] * 3;
            index++;
        }
        return res;
    }
}

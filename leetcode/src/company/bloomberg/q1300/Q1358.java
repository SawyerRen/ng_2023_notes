package company.bloomberg.q1300;

import java.util.HashMap;
import java.util.Map;

public class Q1358 {
    public int numberOfSubstrings(String s) {
        int[] count = new int[3];
        int i = 0, j = 0, res = 0;
        while (j < s.length()) {
            char rc = s.charAt(j);
            count[rc - 'a']++;
            while (count[0] > 0 && count[1] > 0 && count[2] > 0) {
                count[s.charAt(i) - 'a']--;
                i++;
            }
            res += i;
            j++;
        }
        return res;
    }
}

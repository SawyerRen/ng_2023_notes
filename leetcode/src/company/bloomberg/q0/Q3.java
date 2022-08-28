package company.bloomberg.q0;

import java.util.HashSet;
import java.util.Set;

public class Q3 {
    public int lengthOfLongestSubstring(String s) {
        int res = 0, i = 0, j = 0;
        Set<Character> set = new HashSet<>();
        while (j < s.length()) {
            while (set.contains(s.charAt(j))) {
                set.remove(s.charAt(i++));
            }
            set.add(s.charAt(j));
            res = Math.max(res, set.size());
            j++;
        }
        return res;
    }
}

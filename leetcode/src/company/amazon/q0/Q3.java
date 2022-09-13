package company.amazon.q0;

import java.util.HashSet;
import java.util.Set;

public class Q3 {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int i = 0, j = 0, res = 0;
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

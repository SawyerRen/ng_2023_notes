package company.bloomberg.goodluck;

import java.util.HashSet;
import java.util.Set;

public class Q1647 {
    public int minDeletions(String s) {
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        Set<Integer> set = new HashSet<>();
        int res = 0;
        for (int i : count) {
            while (i > 0 && set.contains(i)) {
                res++;
                i--;
            }
            set.add(i);
        }
        return res;
    }
}

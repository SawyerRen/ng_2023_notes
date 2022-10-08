package company.bloomberg.vo;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Q1647 {
    public int minDeletions(String s) {
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        Set<Integer> set = new HashSet<>();
        int res = 0;
        for (int i = 0; i < count.length; i++) {
            while (count[i] > 0 && set.contains(count[i])) {
                res++;
                count[i]--;
            }
            set.add(count[i]);
        }
        return res;
    }
}

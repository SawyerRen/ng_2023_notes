package company.uber.q1200;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Q1239 {
    public int maxLength(List<String> arr) {
        return helper(arr, 0, "");
    }

    private int helper(List<String> arr, int index, String s) {
        Set<Character> set = new HashSet<>();
        for (char c : s.toCharArray()) {
            set.add(c);
        }
        if (set.size() != s.length()) return 0;
        int res = s.length();
        for (int i = index; i < arr.size(); i++) {
            res = Math.max(res, helper(arr, i + 1, s + arr.get(i)));
        }
        return res;
    }
}

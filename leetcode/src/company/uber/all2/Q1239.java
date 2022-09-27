package company.uber.all2;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Q1239 {
    public int maxLength(List<String> arr) {
        return helper(arr, 0, "");
    }

    private int helper(List<String> arr, int i, String s) {
        Set<Character> set = new HashSet<>();
        for (char c : s.toCharArray()) {
            if (!set.add(c)) return 0;
        }
        int res = s.length();
        for (int j = i; j < arr.size(); j++) {
            res = Math.max(res, helper(arr, j, s + arr.get(j)));
        }
        return res;
    }
}

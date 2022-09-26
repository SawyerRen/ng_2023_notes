package company.uber.all1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Q301 {
    public List<String> removeInvalidParentheses(String s) {
        int left = 0, right = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') left++;
            else if (c == ')') {
                if (left > 0) left--;
                else right++;
            }
        }
        StringBuilder builder = new StringBuilder();
        Set<String> res = new HashSet<>();
        helper(res, s, builder, left, right, 0, 0);
        return new ArrayList<>(res);
    }

    private void helper(Set<String> res, String s, StringBuilder builder, int left, int right, int open, int index) {
        if (open < 0 || left < 0 || right < 0) return;
        if (index == s.length()) {
            if (open == 0 && left == 0 && right == 0) {
                res.add(builder.toString());
            }
            return;
        }
        char c = s.charAt(index);
        if (c == '(') {
            helper(res, s, builder, left - 1, right, open, index + 1);
            helper(res, s, builder.append(c), left, right, open + 1, index + 1);
        } else if (c == ')') {
            helper(res, s, builder, left, right - 1, open, index + 1);
            helper(res, s, builder.append(c), left, right, open - 1, index + 1);
        } else {
            helper(res, s, builder.append(c), left, right, open, index + 1);
        }
        builder.setLength(builder.length() - 1);
    }
}

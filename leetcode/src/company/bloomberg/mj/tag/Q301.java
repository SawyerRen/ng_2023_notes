package company.bloomberg.mj.tag;

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
        Set<String> res = new HashSet<>();
        helper(res, new StringBuilder(), left, right, 0, 0, s, 0);
        return new ArrayList<>(res);
    }

    private void helper(Set<String> res, StringBuilder builder, int left, int right, int open, int close, String s, int index) {
        if (left < 0 || right < 0 || open < close) return;
        if (index == s.length()) {
            if (left == 0 && right == 0 && open == close) {
                res.add(builder.toString());
            }
            return;
        }
        char c = s.charAt(index);
        if (c == '(') {
            helper(res, builder, left - 1, right, open, close, s, index + 1);
            helper(res, builder.append(c), left, right, open + 1, close, s, index + 1);
        } else if (c == ')') {
            helper(res, builder, left, right - 1, open, close, s, index + 1);
            helper(res, builder.append(c), left, right, open, close + 1, s, index + 1);
        } else {
            helper(res, builder.append(c), left, right, open, close, s, index + 1);
        }
        builder.setLength(builder.length() - 1);
    }
}

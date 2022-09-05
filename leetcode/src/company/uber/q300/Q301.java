package company.uber.q300;

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
        helper(res, new StringBuilder(), s, left, right, 0, 0);
        return new ArrayList<>(res);
    }

    private void helper(Set<String> res, StringBuilder builder, String s, int left, int right, int open, int index) {
        if (left < 0 || right < 0 || open < 0) return;
        if (index == s.length()) {
            if (left == 0 && right == 0 && open == 0) res.add(builder.toString());
            return;
        }
        int len = builder.length();
        char c = s.charAt(index);
        if (c == '(') {
            helper(res, builder, s, left - 1, right, open, index + 1);
            helper(res, builder.append(c), s, left, right, open + 1, index + 1);
        } else if (c == ')') {
            helper(res, builder, s, left, right - 1, open, index + 1);
            helper(res, builder.append(c), s, left, right, open - 1, index + 1);
        } else {
            helper(res, builder.append(c), s, left, right, open, index + 1);
        }
        builder.setLength(len);
    }
}

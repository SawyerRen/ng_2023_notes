package company.uber.all2;

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
        Set<String> set = new HashSet<>();
        helper(set, new StringBuilder(), left, right, 0, 0, s);
        return new ArrayList<>(set);
    }

    private void helper(Set<String> set, StringBuilder builder, int left, int right, int open, int index, String s) {
        if (left < 0 || right < 0 || open < 0) return;
        if (index == s.length()) {
            if (left == 0 && right == 0 && open == 0) {
                set.add(builder.toString());
            }
            return;
        }
        char c = s.charAt(index);
        if (c == '(') {
            helper(set, builder, left - 1, right, open, index + 1, s);
            helper(set, builder.append(c), left, right, open + 1, index + 1, s);
        } else if (c == ')') {
            helper(set, builder, left, right - 1, open, index + 1, s);
            helper(set, builder.append(c), left, right, open - 1, index + 1, s);
        } else {
            helper(set, builder.append(c), left, right, open, index + 1, s);
        }
        builder.setLength(builder.length() - 1);
    }
}

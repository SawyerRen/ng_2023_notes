package company.uber.q0;

import java.util.ArrayList;
import java.util.List;

public class Q17 {
    String[] arr = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) return new ArrayList<>();
        List<String> res = new ArrayList<>();
        helper(res, digits, 0, new StringBuilder());
        return res;
    }

    private void helper(List<String> res, String digits, int i, StringBuilder builder) {
        if (i == digits.length()) {
            res.add(builder.toString());
            return;
        }
        char c = digits.charAt(i);
        for (char c1 : arr[c - '0'].toCharArray()) {
            builder.append(c1);
            helper(res, digits, i + 1, builder);
            builder.setLength(builder.length() - 1);
        }
    }
}

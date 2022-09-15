package company.amazon.finalround;

import java.util.ArrayList;
import java.util.List;

public class Q17 {
    String[] strs = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) return new ArrayList<>();
        List<String> res = new ArrayList<>();
        helper(res, digits, new StringBuilder(), 0);
        return res;
    }

    private void helper(List<String> res, String digits, StringBuilder builder, int i) {
        if (i == digits.length()) {
            res.add(builder.toString());
            return;
        }
        char c = digits.charAt(i);
        for (char c1 : strs[c - '0'].toCharArray()) {
            builder.append(c1);
            helper(res, digits, builder, i + 1);
            builder.setLength(builder.length() - 1);
        }
    }
}

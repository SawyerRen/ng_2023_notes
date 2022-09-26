package company.uber.all1;

import java.util.ArrayList;
import java.util.List;

public class Q17 {
    String[] arr = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits.isEmpty()) return res;
        StringBuilder builder = new StringBuilder();
        helper(res, builder, digits, 0);
        return res;
    }

    private void helper(List<String> res, StringBuilder builder, String digits, int i) {
        if (i == digits.length()) {
            res.add(builder.toString());
            return;
        }
        char c = digits.charAt(i);
        for (char c1 : arr[c - '0'].toCharArray()) {
            builder.append(c1);
            helper(res, builder, digits, i + 1);
            builder.setLength(builder.length() - 1);
        }
    }
}

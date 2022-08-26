package company.amazon.q0;

import java.util.ArrayList;
import java.util.List;

public class Q17 {
    String[] arr = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits.isEmpty()) return res;
        helper(res, new StringBuilder(), digits, 0);
        return res;
    }

    private void helper(List<String> res, StringBuilder builder, String digits, int i) {
        if (builder.length() == digits.length()) {
            res.add(builder.toString());
            return;
        }
        int index = digits.charAt(i) - '0';
        for (char c : arr[index].toCharArray()) {
            builder.append(c);
            helper(res, builder, digits, i + 1);
            builder.setLength(builder.length() - 1);
        }
    }
}

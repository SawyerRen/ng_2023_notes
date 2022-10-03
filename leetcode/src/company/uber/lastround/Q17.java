package company.uber.lastround;

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

    private void helper(List<String> res, StringBuilder builder, String digits, int index) {
        if (index == digits.length()) {
            res.add(builder.toString());
            return;
        }
        char c = digits.charAt(index);
        for (char num : arr[c - '0'].toCharArray()) {
            builder.append(num);
            helper(res, builder, digits, index + 1);
            builder.setLength(builder.length() - 1);
        }
    }
}

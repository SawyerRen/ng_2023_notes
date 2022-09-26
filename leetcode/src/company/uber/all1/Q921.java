package company.uber.all1;

public class Q921 {
    public int minAddToMakeValid(String s) {
        int left = 0, right = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') left++;
            else if (c == ')') {
                if (left > 0) left--;
                else right++;
            }
        }
        return left + right;
    }
}

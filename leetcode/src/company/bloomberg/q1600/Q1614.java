package company.bloomberg.q1600;

public class Q1614 {
    public int maxDepth(String s) {
        int left = 0, res = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                left++;
                res = Math.max(res, left);
            } else if (c == ')') {
                left--;
            }
        }
        return res;
    }
}

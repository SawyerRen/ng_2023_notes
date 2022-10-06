package company.bloomberg.all.q800;

import java.util.Stack;

public class Q856 {
    public int scoreOfParentheses(String s) {
        int score = 0;
        Stack<Integer> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(score);
                score = 0;
            } else {
                score = stack.pop() + Math.max(1, score * 2);
            }
        }
        return score;
    }
}

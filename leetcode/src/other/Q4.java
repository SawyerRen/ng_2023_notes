package other;

import java.util.Stack;

public class Q4 {
    String solution(String s) {
        Stack<Character> stack = new Stack<>();
        int count = 0;
        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && c == stack.peek()) {
                count++;
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        if (count % 2 == 0) {
            return "A";
        } else {
            return "B";
        }
    }
}

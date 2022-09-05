package company.uber.q700;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Q772 {
    public int calculate(String s) {
        Queue<Character> queue = new LinkedList<>();
        for (char c : s.toCharArray()) {
            queue.add(c);
        }
        queue.add('+');
        return helper(queue);
    }

    private int helper(Queue<Character> queue) {
        char sign = '+';
        int num = 0;
        Stack<Integer> stack = new Stack<>();
        while (!queue.isEmpty()) {
            Character c = queue.poll();
            if (Character.isDigit(c)) {
                num = num * 10 + c - '0';
            } else if (c == '(') {
                num = helper(queue);
            } else {
                if (sign == '+') stack.push(num);
                else if (sign == '-') stack.push(-num);
                else if (sign == '*') stack.push(stack.pop() * num);
                else if (sign == '/') stack.push(stack.pop() / num);
                num = 0;
                sign = c;
                if (c == ')') {
                    break;
                }
            }
        }
        int res = 0;
        while (!stack.isEmpty()) res += stack.pop();
        return res;
    }
}

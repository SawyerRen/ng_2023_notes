package company.uber.q600;

import java.util.Stack;

public class Q682 {
    public int calPoints(String[] ops) {
        Stack<Integer> stack = new Stack<>();
        for (String op : ops) {
            if (op.equals("+")) {
                int num2 = stack.pop();
                int sum = stack.peek() + num2;
                stack.push(num2);
                stack.push(sum);
            } else if (op.equals("D")) {
                stack.push(stack.peek() * 2);
            } else if (op.equals("C")) {
                stack.pop();
            } else {
                stack.push(Integer.parseInt(op));
            }
        }
        int res = 0;
        while (!stack.isEmpty()) res += stack.pop();
        return res;
    }
}

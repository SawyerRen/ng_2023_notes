package company.uber.all1;

import java.util.Stack;

public class Q682 {
    public int calPoints(String[] operations) {
        Stack<Integer> stack = new Stack<>();
        for (String o : operations) {
            if (o.equals("+")) {
                Integer p2 = stack.pop();
                Integer p1 = stack.pop();
                stack.push(p1);
                stack.push(p2);
                stack.push(p1 + p2);
            } else if (o.equals("D")) {
                stack.push(stack.peek() * 2);
            } else if (o.equals("C")) {
                stack.pop();
            } else {
                stack.push(Integer.parseInt(o));
            }
        }
        int res = 0;
        while (!stack.isEmpty()) res += stack.pop();
        return res;
    }
}

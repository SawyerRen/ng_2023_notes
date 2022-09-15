package company.amazon.finalround;

import java.util.Stack;

public class Q735 {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for (int asteroid : asteroids) {
            boolean push = true;
            while (!stack.isEmpty() && asteroid < 0 && stack.peek() > 0) {
                if (-asteroid == stack.peek()) {
                    push = false;
                    stack.pop();
                    break;
                } else if (-asteroid < stack.peek()) {
                    push = false;
                    break;
                } else {
                    stack.pop();
                }
            }
            if (push) stack.push(asteroid);
        }
        int[] res = new int[stack.size()];
        for (int i = res.length - 1; i >= 0; i--) {
            res[i] = stack.pop();
        }
        return res;
    }
}

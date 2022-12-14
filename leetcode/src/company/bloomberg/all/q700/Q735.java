package company.bloomberg.all.q700;

import java.util.LinkedList;

public class Q735 {
    public int[] asteroidCollision(int[] asteroids) {
        LinkedList<Integer> stack = new LinkedList<>();
        for (int asteroid : asteroids) {
            boolean push = true;
            while (!stack.isEmpty() && asteroid < 0 && stack.peekLast() > 0) {
                if (-asteroid == stack.peekLast()) {
                    stack.removeLast();
                    push = false;
                    break;
                } else if (stack.peekLast() > -asteroid) {
                    push = false;
                    break;
                } else {
                    stack.removeLast();
                }
            }
            if (push) stack.addLast(asteroid);
        }
        int[] res = new int[stack.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = stack.removeFirst();
        }
        return res;
    }
}

package company.bloomberg.all.q100;

import java.util.Stack;

public class Q155 {
    class MinStack {
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> minStack = new Stack<>();

        public MinStack() {

        }

        public void push(int val) {
            stack.push(val);
            if (minStack.isEmpty() || val <= minStack.peek()) minStack.push(val);
        }

        public void pop() {
            int val = stack.pop();
            if (val == minStack.peek()) minStack.pop();
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return minStack.peek();
        }
    }
}

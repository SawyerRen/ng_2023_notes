package company.bloomberg.vo;

import java.util.Stack;

public class Q155 {
    class MinStack {
        Stack<Integer> valStack = new Stack<>();
        Stack<Integer> minStack = new Stack<>();

        public MinStack() {

        }

        public void push(int val) {
            valStack.push(val);
            if (minStack.isEmpty() || val <= minStack.peek()) {
                minStack.push(val);
            }
        }

        public void pop() {
            Integer pop = valStack.pop();
            if (!minStack.isEmpty() && pop.equals(minStack.peek())) minStack.pop();
        }

        public int top() {
            return valStack.peek();
        }

        public int getMin() {
            return minStack.peek();
        }
    }
}

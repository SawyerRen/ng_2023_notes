package company.bloomberg.q100;

import java.util.Stack;

public class Q155 {
    class MinStack {
        Stack<Integer> valStack = new Stack<>();
        Stack<Integer> minStack = new Stack<>();

        public MinStack() {

        }

        public void push(int val) {
            valStack.push(val);
            if (minStack.isEmpty()) minStack.push(val);
            else if (val <= minStack.peek()) {
                minStack.push(val);
            }
        }

        public void pop() {
            Integer pop = valStack.pop();
            if (minStack.peek().equals(pop)) {
                minStack.pop();
            }
        }

        public int top() {
            return valStack.peek();
        }

        public int getMin() {
            return minStack.peek();
        }
    }
}

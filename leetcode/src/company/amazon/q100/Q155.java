package company.amazon.q100;

import java.util.Stack;

public class Q155 {
    class MinStack {
        Stack<Integer> vals = new Stack<>();
        Stack<Integer> mins = new Stack<>();

        public MinStack() {

        }

        public void push(int val) {
            vals.push(val);
            if (mins.isEmpty() || mins.peek() >= val) mins.push(val);
        }

        public void pop() {
            Integer pop = vals.pop();
            if (!mins.isEmpty() && mins.peek().equals(pop)) mins.pop();
        }

        public int top() {
            return vals.peek();
        }

        public int getMin() {
            return mins.peek();
        }
    }
}

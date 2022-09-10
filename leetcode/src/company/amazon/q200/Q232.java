package company.amazon.q200;

import java.util.Stack;

public class Q232 {
    class MyQueue {
        Stack<Integer> in = new Stack<>();
        Stack<Integer> out = new Stack<>();

        public MyQueue() {

        }

        public void push(int x) {
            in.push(x);
        }

        public int pop() {
            if (empty()) return -1;
            return out.pop();
        }

        public int peek() {
            if (empty()) return -1;
            return out.peek();
        }

        public boolean empty() {
            if (out.isEmpty()) {
                while (!in.isEmpty()) out.push(in.pop());
            }
            return out.isEmpty();
        }
    }

    class DoubleQueue {
        Stack<Integer> s1;
        Stack<Integer> s2;

        void addLast(int x) {
            while (!s2.isEmpty()) {
                s1.push(s2.pop());
            }
            s1.push(x);
        }

        int popLast() {
            while (!s2.isEmpty()) {
                s1.push(s2.pop());
            }
            if (!s1.isEmpty()) {
                return s1.pop();
            }
            return -1;
        }

        void addFirst(int x) {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
            s2.push(x);
        }

        int popFirst() {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
            if (!s2.isEmpty()) {
                return s2.pop();
            }
            return -1;
        }
    }
}

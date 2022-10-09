package company.bloomberg.mj.tag;

import java.util.Stack;

public class Q155 {
    class Node {
        int val;
        int min;
        Node next;

        public Node(int val, int min, Node next) {
            this.val = val;
            this.min = min;
            this.next = next;
        }
    }

    class MinStack1 {
        Node head;

        public MinStack1() {

        }

        public void push(int val) {
            if (head == null) {
                head = new Node(val, val, null);
            } else {
                head = new Node(val, Math.min(val, head.min), head);
            }
        }

        public void pop() {
            head = head.next;
        }

        public int top() {
            return head.val;
        }

        public int getMin() {
            return head.min;
        }
    }

    class MinStack {
        Stack<Integer> valStack = new Stack<>();
        Stack<Integer> minStack = new Stack<>();

        public MinStack() {

        }

        public void push(int val) {
            valStack.push(val);
            if (minStack.isEmpty() || minStack.peek() >= val) {
                minStack.push(val);
            }
        }

        public void pop() {
            int val = valStack.pop();
            if (val == minStack.peek()) {
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

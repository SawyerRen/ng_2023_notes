package company.bloomberg.q100;

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

    class MinStack {
        Node head;

        public MinStack() {

        }

        public void push(int val) {
            if (head == null) head = new Node(val, val, null);
            else head = new Node(val, Math.min(val, head.min), head);
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
}

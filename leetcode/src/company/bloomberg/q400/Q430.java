package company.bloomberg.q400;

import java.util.Stack;

public class Q430 {
    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    }

    Node pre = null;

    public Node flatten(Node head) {
        if (head == null) return null;
        if (pre != null) {
            pre.next = head;
            head.prev = pre;
        }
        pre = head;
        Node next = head.next;
        flatten(head.child);
        head.child = null;
        flatten(next);
        return head;
    }

    public Node flatten1(Node head) {
        Stack<Node> stack = new Stack<>();
        Node cur = head;
        while (cur != null) {
            if (cur.child != null) {
                Node next = cur.next;
                if (next != null) stack.push(next);
                cur.next = cur.child;
                cur.next.prev = cur;
                cur.child = null;
            } else if (cur.next == null && !stack.isEmpty()) {
                cur.next = stack.pop();
                cur.next.prev = cur;
            }
            cur = cur.next;
        }
        return head;
    }
}

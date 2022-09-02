package company.bloomberg.q400;

import java.util.LinkedList;
import java.util.Queue;
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
        if (head.child != null) {
            flatten(head.child);
            head.child = null;
        }
        if (head.next != null) {
            flatten(next);
        }
        return head;
    }

    public Node flatten1(Node head) {
        if (head == null) return null;
        Node cur = head;
        Stack<Node> stack = new Stack<>();
        while (cur != null) {
            if (cur.child != null) {
                if (cur.next != null) stack.add(cur.next);
                cur.next = cur.child;
                cur.child = null;
                cur.next.prev = cur;
            } else if (cur.next == null && !stack.isEmpty()) {
                cur.next = stack.pop();
                cur.next.prev = cur;
            }
            cur = cur.next;
        }
        return head;
    }

    public Node bfs(Node head) {
        if (head == null) return null;
        Node dummy = new Node();
        Node cur = dummy;
        Queue<Node> queue = new LinkedList<>();
        queue.add(cur);
        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            while (poll != null) {
                cur.next = poll;
                poll.prev = cur;
                cur = cur.next;
                if (poll.child != null) {
                    queue.add(poll.child);
                    poll.child = null;
                }
                poll = poll.next;
            }
        }
        return dummy.next;
    }
}

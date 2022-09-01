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
        flatten(head.child);
        head.child = null;
        flatten(next);
        return head;
    }

    public Node flatten1(Node head) {
        if (head == null) return null;
        Stack<Node> stack = new Stack<>();
        Node cur = head;
        while (cur != null) {
            if (cur.child != null) {
                if (cur.next != null) stack.push(cur.next);
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

    Node bfs(Node node) {
        if (node == null) return null;
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        Node cur = node;
        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            while (poll != null) {
                cur.next = poll;
                cur = cur.next;
                if (poll.child != null) queue.add(poll.child);
                poll = poll.next;
            }
        }
        return node;
    }
}

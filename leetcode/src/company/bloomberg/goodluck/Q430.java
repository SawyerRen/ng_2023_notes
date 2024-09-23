package company.bloomberg.goodluck;

import java.util.Stack;

public class Q430 {
    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    }

    public Node flatten(Node head) {
        if (head == null) return null;
        Stack<Node> stack = new Stack<>();
        Node cur = head;
        while (cur != null) {
            // 如果child不是null，把next存到stack中，将child变成cur.next
            if (cur.child != null) {
                if (cur.next != null) stack.push(cur.next);
                cur.child.prev = cur;
                cur.next = cur.child;
                cur.child = null;
            // cur的next为null，从stack中取出Node作为next节点
            } else if (cur.next == null && !stack.isEmpty()) {
                Node next = stack.pop();
                cur.next = next;
                next.prev = cur;
            }
            cur = cur.next;
        }
        return head;
    }
}

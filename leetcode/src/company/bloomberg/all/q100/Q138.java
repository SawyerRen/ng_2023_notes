package company.bloomberg.all.q100;

import java.util.HashMap;
import java.util.Map;

public class Q138 {
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {
        if (head == null) return null;
        Node cur = head;
        while (cur != null) {
            Node next = cur.next;
            Node node = new Node(cur.val);
            cur.next = node;
            node.next = next;
            cur = next;
        }
        cur = head;
        while (cur != null) {
            if (cur.random != null) {
                cur.next.random = cur.random.next;
            }
            cur = cur.next.next;
        }
        cur = head;
        Node copyHead = head.next;
        while (cur != null) {
            Node next = cur.next.next;
            if (next != null) {
                cur.next.next = next.next;
            }
            cur.next = next;
            cur = cur.next;
        }
        return copyHead;
    }

    public Node copyRandomList1(Node head) {
        if (head == null) return null;
        Map<Node, Node> map = new HashMap<>();
        Node cur = head;
        while (cur != null) {
            map.put(cur, new Node(cur.val));
            cur = cur.next;
        }
        cur = head;
        while (cur != null) {
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }
        return map.get(head);
    }
}

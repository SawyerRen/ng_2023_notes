package company.amazon.finalround;

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
            Node next = new Node(cur.val);
            next.next = cur.next;
            cur.next = next;
            cur = cur.next.next;
        }
        cur = head;
        while (cur != null) {
            if (cur.random != null) {
                cur.next.random = cur.random.next;
            }
            cur = cur.next.next;
        }
        cur = head;
        Node res = head.next;
        while (cur != null) {
            Node next = cur.next.next;
            if (next != null) {
                cur.next.next = next.next;
            }
            cur.next = next;
            cur = next;
        }
        return res;
    }
}

package company.bloomberg.vo;

public class Q117 {
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    public Node connect(Node root) {
        if (root == null) return null;
        Node head = root;
        while (head != null) {
            Node nextHead = null;
            Node cur = head;
            while (cur != null) {
                if (cur.left != null) {
                    if (nextHead == null) nextHead = cur.left;
                    if (cur.right != null) {
                        cur.left.next = cur.right;
                    } else {
                        cur.left.next = findNext(cur.next);
                    }
                }
                if (cur.right != null) {
                    if (nextHead == null) nextHead = cur.right;
                    cur.right.next = findNext(cur.next);
                }
                cur = cur.next;
            }
            head = nextHead;
        }
        return root;
    }

    private Node findNext(Node cur) {
        while (cur != null) {
            if (cur.left != null) return cur.left;
            if (cur.right != null) return cur.right;
            cur = cur.next;
        }
        return null;
    }
}

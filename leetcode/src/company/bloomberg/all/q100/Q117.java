package company.bloomberg.all.q100;

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
        Node cur = root;
        while (cur != null) {
            Node nextHead = null;
            while (cur != null) {
                if (cur.left != null) {
                    nextHead = nextHead == null ? cur.left : nextHead;
                    if (cur.right != null) {
                        cur.left.next = cur.right;
                    } else {
                        cur.left.next = findNext(cur.next);
                    }
                }
                if (cur.right != null) {
                    nextHead = nextHead == null ? cur.right : nextHead;
                    cur.right.next = findNext(cur.next);
                }
                cur = cur.next;
            }
            cur = nextHead;
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

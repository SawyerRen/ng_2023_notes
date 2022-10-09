package company.bloomberg.mj.tag;

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
        Node left = root;
        while (left != null) {
            Node cur = left;
            Node next = null;
            while (cur != null) {
                if (cur.left != null) {
                    next = next == null ? cur.left : next;
                    if (cur.right != null) {
                        cur.left.next = cur.right;
                    } else {
                        cur.left.next = findNext(cur.next);
                    }
                }
                if (cur.right != null) {
                    next = next == null ? cur.right : next;
                    cur.right.next = findNext(cur.next);
                }
                cur = cur.next;
            }
            left = next;
        }
        return root;
    }

    private Node findNext(Node node) {
        while (node != null) {
            if (node.left != null) return node.left;
            if (node.right != null) return node.right;
            node = node.next;
        }
        return null;
    }
}

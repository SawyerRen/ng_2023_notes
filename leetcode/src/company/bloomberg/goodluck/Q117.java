package company.bloomberg.goodluck;

import java.util.LinkedList;
import java.util.Queue;

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
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node poll = queue.poll();
                if (i != size - 1) poll.next = queue.peek();
                if (poll.left != null) queue.add(poll.left);
                if (poll.right != null) queue.add(poll.right);
            }
        }
        return root;
    }

    public Node connect1(Node root) {
        if (root == null) return null;
        Node left = root;
        while (left != null) {
            Node cur = left;
            Node nextLeft = null;
            while (cur != null) {
                if (cur.left != null) {
                    if (nextLeft == null) nextLeft = cur.left;
                    if (cur.right != null) {
                        cur.left.next = cur.right;
                    } else {
                        cur.left.next = findNext(cur.next);
                    }
                }
                if (cur.right != null) {
                    if (nextLeft == null) nextLeft = cur.right;
                    cur.right.next = findNext(cur.next);
                }
                cur = cur.next;
            }
            left = nextLeft;
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

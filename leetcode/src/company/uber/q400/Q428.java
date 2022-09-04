package company.uber.q400;

import java.util.*;

public class Q428 {
    private class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    class Codec {
        // Encodes a tree to a single string.
        public String serialize(Node root) {
            StringBuilder builder = new StringBuilder();
            _ser(builder, root);
            return builder.toString();
        }

        private void _ser(StringBuilder builder, Node root) {
            if (root == null) return;
            builder.append(root.val).append(",");
            builder.append(root.children.size()).append(",");
            for (Node child : root.children) {
                _ser(builder, child);
            }
        }

        // Decodes your encoded data to tree.
        public Node deserialize(String data) {
            if (data.isEmpty()) return null;
            Queue<String> queue = new LinkedList<>(Arrays.asList(data.split(",")));
            return _des(queue);
        }

        private Node _des(Queue<String> queue) {
            if (queue.isEmpty()) return null;
            int val = Integer.parseInt(queue.poll());
            int size = Integer.parseInt(queue.poll());
            Node root = new Node(val, new ArrayList<>());
            for (int i = 0; i < size; i++) {
                root.children.add(_des(queue));
            }
            return root;
        }
    }
}

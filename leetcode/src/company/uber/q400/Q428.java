package company.uber.q400;

import java.util.*;

public class Q428 {
    class Node {
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
            _serialize(root, builder);
            return builder.toString();
        }

        private void _serialize(Node root, StringBuilder builder) {
            if (root == null) return;
            builder.append(root.val).append(",");
            builder.append(root.children.size()).append(",");
            for (Node child : root.children) {
                _serialize(child, builder);
            }
        }

        // Decodes your encoded data to tree.
        public Node deserialize(String data) {
            if (data.length() == 0) return null;
            Queue<String> queue = new LinkedList<>(Arrays.asList(data.split(",")));
            return _deserialize(queue);
        }

        private Node _deserialize(Queue<String> queue) {
            if (queue.isEmpty()) return null;
            int val = Integer.parseInt(queue.poll());
            int size = Integer.parseInt(queue.poll());
            Node node = new Node(val, new ArrayList<>(size));
            for (int i = 0; i < size; i++) {
                node.children.add(_deserialize(queue));
            }
            return node;
        }
    }
}

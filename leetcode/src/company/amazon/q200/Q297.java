package company.amazon.q200;

import model.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeMap;

public class Q297 {
    public class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            StringBuilder builder = new StringBuilder();
            _ser(root, builder);
            return builder.toString();
        }

        private void _ser(TreeNode root, StringBuilder builder) {
            if (root == null) {
                builder.append("null").append(",");
                return;
            }
            builder.append(root.val).append(",");
            _ser(root.left, builder);
            _ser(root.right, builder);
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            Queue<String> queue = new LinkedList<>(Arrays.asList(data.split(",")));
            return _des(queue);
        }

        private TreeNode _des(Queue<String> queue) {
            if (queue.isEmpty()) return null;
            String poll = queue.poll();
            if (poll.equals("null")) return null;
            TreeNode root = new TreeNode(Integer.parseInt(poll));
            root.left = _des(queue);
            root.right = _des(queue);
            return root;
        }
    }
}

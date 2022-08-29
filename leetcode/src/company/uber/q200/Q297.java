package company.uber.q200;

import model.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Q297 {
    public class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            StringBuilder builder = new StringBuilder();
            _serialize(builder, root);
            return builder.toString();
        }

        private void _serialize(StringBuilder builder, TreeNode root) {
            if (root == null) {
                builder.append("null,");
                return;
            }
            builder.append(root.val).append(",");
            _serialize(builder, root.left);
            _serialize(builder, root.right);
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

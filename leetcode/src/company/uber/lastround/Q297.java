package company.uber.lastround;

import model.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Q297 {
    public class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            StringBuilder builder = new StringBuilder();
            se(builder, root);
            return builder.toString();
        }

        private void se(StringBuilder builder, TreeNode root) {
            if (root == null) {
                builder.append("null,");
                return;
            }
            builder.append(root.val).append(",");
            se(builder, root.left);
            se(builder, root.right);
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if (data.isEmpty()) return null;
            Queue<String> queue = new LinkedList<>(Arrays.asList(data.split(",")));
            return des(queue);
        }

        private TreeNode des(Queue<String> queue) {
            if (queue.isEmpty()) return null;
            String poll = queue.poll();
            if (poll.equals("null")) return null;
            TreeNode root = new TreeNode(Integer.parseInt(poll));
            root.left = des(queue);
            root.right = des(queue);
            return root;
        }
    }
}

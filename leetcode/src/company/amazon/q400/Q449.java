package company.amazon.q400;

import model.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Q449 {
    public class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            StringBuilder builder = new StringBuilder();
            _se(builder, root);
            return builder.toString();
        }

        private void _se(StringBuilder builder, TreeNode root) {
            if (root == null) return;
            builder.append(root.val).append(",");
            _se(builder, root.left);
            _se(builder, root.right);
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if (data.isEmpty()) return null;
            Queue<String> queue = new LinkedList<>(Arrays.asList(data.split(",")));
            return _des(queue, Integer.MIN_VALUE, Integer.MAX_VALUE);
        }

        private TreeNode _des(Queue<String> queue, int min, int max) {
            if (queue.isEmpty()) return null;
            int val = Integer.parseInt(queue.peek());
            if (val <= min || val >= max) return null;
            queue.poll();
            TreeNode root = new TreeNode(val);
            root.left = _des(queue, min, root.val);
            root.right = _des(queue, root.val, max);
            return root;
        }
    }
}

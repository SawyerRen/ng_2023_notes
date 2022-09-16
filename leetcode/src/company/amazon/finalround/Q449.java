package company.amazon.finalround;

import model.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Q449 {
    public class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            StringBuilder builder = new StringBuilder();
            dfs(builder, root);
            return builder.toString();
        }

        private void dfs(StringBuilder builder, TreeNode root) {
            if (root == null) return;
            builder.append(root.val).append(",");
            dfs(builder, root.left);
            dfs(builder, root.right);
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

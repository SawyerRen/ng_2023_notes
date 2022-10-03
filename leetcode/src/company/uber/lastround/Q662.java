package company.uber.lastround;

import model.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Q662 {
    public int widthOfBinaryTree(TreeNode root) {
        Queue<TreeNode> nodes = new LinkedList<>();
        Queue<Integer> cols = new LinkedList<>();
        if (root == null) return 0;
        nodes.add(root);
        cols.add(1);
        int res = 1;
        while (!nodes.isEmpty()) {
            Integer min = null, max = null;
            int size = nodes.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = nodes.poll();
                Integer col = cols.poll();
                min = min == null ? col : min;
                max = col;
                if (node.left != null) {
                    nodes.add(node.left);
                    cols.add(col * 2);
                }
                if (node.right != null) {
                    nodes.add(node.right);
                    cols.add(col * 2 + 1);
                }
            }
            res = Math.max(res, max - min + 1);
        }
        return res;
    }
}

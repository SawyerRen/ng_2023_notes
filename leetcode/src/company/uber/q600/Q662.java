package company.uber.q600;

import model.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Q662 {
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> cols = new LinkedList<>();
        queue.add(root);
        cols.add(1);
        int res = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            Integer min = null, max = null;
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                Integer col = cols.poll();
                min = min == null ? col : min;
                max = col;
                if (poll.left != null) {
                    queue.add(poll.left);
                    cols.add(col * 2);
                }
                if (poll.right != null) {
                    queue.add(poll.right);
                    cols.add(col * 2 + 1);
                }
            }
            res = Math.max(res, max - min + 1);
        }
        return res;
    }
}

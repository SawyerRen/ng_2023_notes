package company.amazon.finalround;

import model.TreeNode;

public class Q1372 {
    int res = 0;

    public int longestZigZag(TreeNode root) {
        helper(root, true, 0);
        helper(root, false, 0);
        return res;
    }

    private void helper(TreeNode root, boolean isLeft, int depth) {
        if (root == null) return;
        res = Math.max(res, depth);
        if (isLeft) {
            helper(root.right, false, depth + 1);
            helper(root.left, true, 1);
        } else {
            helper(root.left, true, depth + 1);
            helper(root.right, false, 1);
        }
    }
}

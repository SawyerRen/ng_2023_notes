package company.amazon.q1300;

import model.TreeNode;

public class Q1372 {
    int res = 0;

    public int longestZigZag(TreeNode root) {
        helper(root, true, 0);
        helper(root, false, 0);
        return res;
    }

    private void helper(TreeNode root, boolean isLeft, int len) {
        if (root == null) return;
        res = Math.max(res, len);
        if (isLeft) {
            helper(root.right, false, len + 1);
            helper(root.left, true, 1);
        } else {
            helper(root.left, true, len + 1);
            helper(root.right, false, 1);
        }
    }
}

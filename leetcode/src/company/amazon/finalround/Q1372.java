package company.amazon.finalround;

import model.TreeNode;

public class Q1372 {
    int res = 0;

    public int longestZigZag(TreeNode root) {
        if (root == null) return 0;
        helper(root, true, 0);
        helper(root, false, 0);
        return res;
    }

    private void helper(TreeNode root, boolean isLeft, int length) {
        if (root == null) return;
        res = Math.max(res, length);
        if (isLeft) {
            helper(root.right, false, length + 1);
            helper(root.left, true, 1);
        } else {
            helper(root.left, true, length + 1);
            helper(root.right, false, 1);
        }
    }
}

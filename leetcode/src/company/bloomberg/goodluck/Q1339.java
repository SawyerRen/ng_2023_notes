package company.bloomberg.goodluck;

import model.TreeNode;

public class Q1339 {
    int res = 0;

    public int maxProduct(TreeNode root) {
        int total = helper(root);
        la(root, total);
        return res;
    }

    private int la(TreeNode root, int total) {
        if (root == null) return 0;
        int part = root.val + la(root.left, total) + la(root.right, total);
        res = Math.max(res, part * (total - part));
        return part;
    }

    private int helper(TreeNode root) {
        if (root == null) return 0;
        return root.val + helper(root.left) + helper(root.right);
    }
}

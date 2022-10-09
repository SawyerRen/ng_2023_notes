package company.bloomberg.r2;

import model.TreeNode;

public class Q1339 {
    long res = 0;

    public int maxProduct(TreeNode root) {
        long total = getTotal(root);
        helper(root, total);
        return (int) (res % (int) (1e9 + 7));
    }

    private long helper(TreeNode root, long total) {
        if (root == null) return 0;
        long partSum = root.val + helper(root.left, total) + helper(root.right, total);
        res = Math.max(res, partSum * (total - partSum));
        return partSum;
    }

    private int getTotal(TreeNode root) {
        if (root == null) return 0;
        return root.val + getTotal(root.left) + getTotal(root.right);
    }
}

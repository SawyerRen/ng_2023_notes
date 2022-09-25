package company.uber.all1;

import model.TreeNode;

public class Q1740 {
    public int findDistance(TreeNode root, int p, int q) {
        TreeNode lca = findLca(root, p, q);
        return helper(lca, p) + helper(lca, q);
    }

    private int helper(TreeNode root, int p) {
        if (root == null) return -1;
        if (root.val == p) return 0;
        int left = helper(root.left, p);
        if (left >= 0) {
            return left + 1;
        }
        int right = helper(root.right, p);
        if (right >= 0) {
            return right + 1;
        }
        return -1;
    }

    private TreeNode findLca(TreeNode root, int p, int q) {
        if (root == null) return null;
        if (root.val == p || root.val == q) return root;
        TreeNode left = findLca(root.left, p, q);
        TreeNode right = findLca(root.right, p, q);
        if (left != null && right != null) return root;
        if (left != null) return left;
        return right;
    }
}

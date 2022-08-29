package company.uber.q1700;

import model.TreeNode;

public class Q1740 {
    public int findDistance(TreeNode root, int p, int q) {
        TreeNode lca = findLCA(root, p, q);
        return findDist(lca, p) + findDist(lca, q);
    }

    private int findDist(TreeNode root, int p) {
        if (root == null) return -1;
        if (root.val == p) return 0;
        int left = findDist(root.left, p);
        if (left >= 0) return left + 1;
        int right = findDist(root.right, p);
        if (right >= 0) return right + 1;
        return -1;
    }

    private TreeNode findLCA(TreeNode root, int p, int q) {
        if (root == null) return null;
        if (root.val == p || root.val == q) return root;
        TreeNode left = findLCA(root.left, p, q);
        TreeNode right = findLCA(root.right, p, q);
        if (left != null && right != null) {
            return root;
        }
        if (left != null) return left;
        return right;
    }
}

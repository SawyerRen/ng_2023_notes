package company.uber.lastround;

import model.TreeNode;

import java.util.TreeMap;

public class Q1740 {
    public int findDistance(TreeNode root, int p, int q) {
        TreeNode lca = findLCA(root, p, q);
        return helper(lca, p) + helper(lca, q);
    }

    private int helper(TreeNode root, int target) {
        if (root == null) return -1;
        if (root.val == target) return 0;
        int left = helper(root.left, target);
        if (left != -1) {
            return left + 1;
        }
        int right = helper(root.right, target);
        if (right != -1) {
            return right + 1;
        }
        return -1;
    }

    private TreeNode findLCA(TreeNode root, int p, int q) {
        if (root == null) return null;
        if (root.val == p || root.val == q) return root;
        TreeNode left = findLCA(root.left, p, q);
        TreeNode right = findLCA(root.right, p, q);
        if (left != null && right != null) return root;
        if (left != null) return left;
        return right;
    }
}

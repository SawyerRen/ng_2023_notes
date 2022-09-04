package company.uber.q1700;

import model.TreeNode;

public class Q1740 {
    public int findDistance(TreeNode root, int p, int q) {
        TreeNode node = findParent(root, p, q);
        return findDist(node, p) + findDist(node, q);
    }

    private int findDist(TreeNode node, int target) {
        if (node == null) return -1;
        if (node.val == target) return 0;
        int left = findDist(node.left, target);
        if (left >= 0) return left + 1;
        int right = findDist(node.right, target);
        if (right >= 0) return right + 1;
        return -1;
    }

    private TreeNode findParent(TreeNode root, int p, int q) {
        if (root == null) return null;
        if (root.val == p || root.val == q) return root;
        TreeNode left = findParent(root.left, p, q);
        TreeNode right = findParent(root.right, p, q);
        if (left != null && right != null) return root;
        if (left != null) return left;
        return right;
    }
}

package company.uber.q1700;

import model.TreeNode;

public class Q1740 {
    int res = 0;

    public int findDistance(TreeNode root, int p, int q) {
        if (p == q) return 0;
        helper(root, p, q);
        return res;
    }

    private int helper(TreeNode root, int p, int q) {
        if (root == null) return -1;
        int left = helper(root.left, p, q);
        int right = helper(root.right, p, q);
        if (root.val == p || root.val == q) {
            if (left < 0 && right < 0) return 0;
            res = Math.max(left, right) + 1;
            return -1;
        }
        if (left >= 0 && right >= 0) {
            res = left + right + 2;
            return -1;
        }
        if (left >= 0) return left + 1;
        if (right >= 0) return right + 1;
        return -1;
    }
}

package company.uber.q100;

import model.TreeNode;

public class Q101 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return helpr(root.left, root.right);
    }

    private boolean helpr(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null) return false;
        if (left.val != right.val) return false;
        return helpr(left.left, right.right) && helpr(left.right, right.left);
    }
}

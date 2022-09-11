package company.amazon.q0;

import model.TreeNode;

public class Q99 {
    TreeNode n1 = null, n2 = null;
    TreeNode pre = null;

    public void recoverTree(TreeNode root) {
        helper(root);
        int val = n1.val;
        n1.val = n2.val;
        n2.val = val;
    }

    private void helper(TreeNode root) {
        if (root == null) return;
        helper(root.left);
        if (pre != null && root.val < pre.val) {
            n1 = n1 == null ? pre : n1;
            n2 = root;
        }
        pre = root;
        helper(root.right);
    }
}


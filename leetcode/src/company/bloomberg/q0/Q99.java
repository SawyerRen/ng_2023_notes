package company.bloomberg.q0;

import model.TreeNode;

public class Q99 {
    TreeNode pre;
    TreeNode n1, n2;

    public void recoverTree(TreeNode root) {
        helper(root);
        int n = n1.val;
        n1.val = n2.val;
        n2.val = n;
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

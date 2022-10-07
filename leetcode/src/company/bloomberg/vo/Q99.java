package company.bloomberg.vo;

import model.TreeNode;

public class Q99 {
    TreeNode n1 = null, n2 = null, pre = null;

    public void recoverTree(TreeNode root) {
        helper(root);
        int v = n1.val;
        n1.val = n2.val;
        n2.val = v;
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

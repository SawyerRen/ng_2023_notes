package company.amazon.q1000;

import model.TreeNode;

public class Q1038 {
    int pre = 0;

    public TreeNode bstToGst(TreeNode root) {
        helper(root);
        return root;
    }

    private void helper(TreeNode root) {
        if (root == null) return;
        helper(root.right);
        root.val += pre;
        pre = root.val;
        helper(root.left);
    }
}

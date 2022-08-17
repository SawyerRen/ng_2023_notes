package company.uber.q200;

import model.TreeNode;

public class Q230 {
    int count = 0, res = 0;

    public int kthSmallest(TreeNode root, int k) {
        helper(root, k);
        return res;
    }

    private void helper(TreeNode root, int k) {
        if (root == null) return;
        helper(root.left, k);
        count++;
        if (count == k) {
            res = root.val;
            return;
        }
        helper(root.right, k);
    }
}

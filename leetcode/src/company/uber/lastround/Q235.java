package company.uber.lastround;

import model.TreeNode;

public class Q235 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        while (root != null) {
            if (root.val < p.val && root.val < q.val) root = root.right;
            else if (root.val > p.val && root.val > q.val) root = root.left;
            else return root;
        }
        return null;
    }
}

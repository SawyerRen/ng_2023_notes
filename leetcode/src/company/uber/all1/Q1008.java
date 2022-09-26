package company.uber.all1;

import model.TreeNode;

public class Q1008 {
    int index = 0;

    public TreeNode bstFromPreorder(int[] preorder) {
        return helper(preorder, Integer.MAX_VALUE);
    }

    private TreeNode helper(int[] preorder, int maxValue) {
        if (index >= preorder.length) return null;
        if (preorder[index] >= maxValue) return null;
        TreeNode root = new TreeNode(preorder[index++]);
        root.left = helper(preorder, root.val);
        root.right = helper(preorder, maxValue);
        return root;
    }
}

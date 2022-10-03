package company.uber.lastround;

import model.TreeNode;

public class Q1008 {
    int index = 0;

    public TreeNode bstFromPreorder(int[] preorder) {
        return helper(preorder, Integer.MAX_VALUE);
    }

    private TreeNode helper(int[] preorder, int maxValue) {
        if (index == preorder.length) return null;
        int val = preorder[index];
        if (val >= maxValue) return null;
        index++;
        TreeNode root = new TreeNode(val);
        root.left = helper(preorder, root.val);
        root.right = helper(preorder, maxValue);
        return root;
    }
}

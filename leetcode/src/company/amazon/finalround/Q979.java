package company.amazon.finalround;

import model.TreeNode;

public class Q979 {
    int res = 0;

    public int distributeCoins(TreeNode root) {
        helper(root);
        return res;
    }

    private int[] helper(TreeNode root) {
        if (root == null) return new int[]{0, 0};
        int[] left = helper(root.left);
        int[] right = helper(root.right);
        res += Math.abs(left[1] - left[0]) + Math.abs(right[1] - right[0]);
        return new int[]{left[0] + right[0] + 1, left[1] + right[1] + root.val};
    }
}

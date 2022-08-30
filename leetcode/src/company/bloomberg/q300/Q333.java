package company.bloomberg.q300;

import model.TreeNode;

public class Q333 {
    class Result {
        int size;
        int min;
        int max;

        public Result(int size, int min, int max) {
            this.size = size;
            this.min = min;
            this.max = max;
        }
    }

    public int largestBSTSubtree(TreeNode root) {
        Result result = helper(root);
        return result.size;
    }

    private Result helper(TreeNode root) {
        if (root == null) {
            return new Result(0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }
        Result left = helper(root.left);
        Result right = helper(root.right);
        if (root.val > left.max && root.val < right.min) {
            return new Result(left.size + right.size + 1, Math.min(root.val, left.min), Math.max(root.val, right.max));
        } else {
            return new Result(Math.max(left.size, right.size), Integer.MIN_VALUE, Integer.MAX_VALUE);
        }
    }
}

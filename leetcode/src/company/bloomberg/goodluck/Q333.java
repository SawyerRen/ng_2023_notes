package company.bloomberg.goodluck;

import model.TreeNode;

public class Q333 {
    class Result {
        int min;
        int max;
        int size;

        public Result(int min, int max, int size) {
            this.min = min;
            this.max = max;
            this.size = size;
        }
    }

    public int largestBSTSubtree(TreeNode root) {
        Result result = helper(root);
        return result.size;
    }

    private Result helper(TreeNode root) {
        if (root == null) {
            return new Result(Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
        }
        Result left = helper(root.left);
        Result right = helper(root.right);
        if (root.val <= left.max || root.val >= right.min) {
            return new Result(Integer.MIN_VALUE, Integer.MAX_VALUE, Math.max(left.size, right.size));
        } else {
            int size = left.size + right.size + 1;
            int min = Math.min(root.val, left.min);
            int max = Math.max(root.val, right.max);
            return new Result(min, max, size);
        }
    }
}

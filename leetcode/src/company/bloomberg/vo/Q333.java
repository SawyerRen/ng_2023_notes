package company.bloomberg.vo;

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
            int min = Math.min(left.min, root.val);
            int max = Math.max(right.max, root.val);
            int size = left.size + right.size + 1;
            return new Result(min, max, size);
        }
    }
}

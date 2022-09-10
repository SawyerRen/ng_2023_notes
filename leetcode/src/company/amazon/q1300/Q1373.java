package company.amazon.q1300;

import model.TreeNode;

public class Q1373 {
    class Result {
        int min;
        int max;
        int sum;

        public Result(int min, int max, int sum) {
            this.min = min;
            this.max = max;
            this.sum = sum;
        }
    }

    int res = 0;

    public int maxSumBST(TreeNode root) {
        Result result = helper(root);
        return res;
    }

    private Result helper(TreeNode root) {
        if (root == null) return new Result(Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
        Result left = helper(root.left);
        Result right = helper(root.right);
        if (root.val <= left.max || root.val >= right.min) {
            return new Result(Integer.MIN_VALUE, Integer.MAX_VALUE, 0);
        } else {
            res = Math.max(res, left.sum + right.sum + root.val);
            return new Result(Math.min(left.min, root.val), Math.max(right.max, root.val), left.sum + right.sum + root.val);
        }
    }
}

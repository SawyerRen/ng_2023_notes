package company.bloomberg.vo;

import model.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Q113 {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        helper(res, new ArrayList<Integer>(), root, targetSum, 0);
        return res;
    }

    private void helper(List<List<Integer>> res, ArrayList<Integer> list, TreeNode root, int targetSum, int sum) {
        if (root == null) return;
        sum += root.val;
        list.add(root.val);
        if (root.left == null && root.right == null) {
            if (sum == targetSum) {
                res.add(new ArrayList<>(list));
            }
        } else {
            helper(res, list, root.left, targetSum, sum);
            helper(res, list, root.right, targetSum, sum);
        }
        list.remove(list.size() - 1);
    }
}

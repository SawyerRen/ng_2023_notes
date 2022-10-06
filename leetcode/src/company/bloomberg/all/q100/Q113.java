package company.bloomberg.all.q100;

import model.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Q113 {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        helper(res, new ArrayList<Integer>(), root, targetSum);
        return res;
    }

    private void helper(List<List<Integer>> res, ArrayList<Integer> list, TreeNode root, int targetSum) {
        if (root == null) return;
        list.add(root.val);
        targetSum -= root.val;
        if (root.left == null && root.right == null) {
            if (targetSum == 0) res.add(new ArrayList<>(list));
        } else {
            helper(res, list, root.left, targetSum);
            helper(res, list, root.right, targetSum);
        }
        list.remove(list.size() - 1);
    }
}

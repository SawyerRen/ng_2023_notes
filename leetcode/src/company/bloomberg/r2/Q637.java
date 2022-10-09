package company.bloomberg.r2;

import model.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class Q637 {
    int res = 0;

    public int pathSum(TreeNode root, int targetSum) {
        Map<Long, Integer> map = new HashMap<>();
        map.put(0L, 1);
        helper(root, map, targetSum, 0);
        return res;
    }

    private void helper(TreeNode root, Map<Long, Integer> map, int targetSum, long sum) {
        if (root == null) return;
        sum += root.val;
        res += map.getOrDefault(sum - targetSum, 0);
        map.put(sum, map.getOrDefault(sum, 0) + 1);
        helper(root.left, map, targetSum, sum);
        helper(root.right, map, targetSum, sum);
        map.put(sum, map.get(sum) - 1);
    }
}

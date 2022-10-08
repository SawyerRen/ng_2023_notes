package company.bloomberg.vo;

import model.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class Q437 {
    int res = 0;

    public int pathSum(TreeNode root, int targetSum) {
        Map<Long, Long> map = new HashMap<>();
        map.put(0L, 1L);
        helper(root, map, targetSum, 0);
        return res;
    }

    private void helper(TreeNode root, Map<Long, Long> map, int target, long sum) {
        if (root == null) return;
        sum += root.val;
        res += map.getOrDefault(sum - target, 0L);
        map.put(sum, map.getOrDefault(sum, 0L) + 1);
        helper(root.left, map, target, sum);
        helper(root.right, map, target, sum);
        map.put(sum, map.get(sum) - 1);
    }
}

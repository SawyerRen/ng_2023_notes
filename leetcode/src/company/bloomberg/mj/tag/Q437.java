package company.bloomberg.mj.tag;

import model.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class Q437 {
    int res = 0;

    public int pathSum(TreeNode root, int targetSum) {
        Map<Long, Integer> map = new HashMap<>();
        map.put(0L, 1);
        helper(map, root, targetSum, 0);
        return res;
    }

    private void helper(Map<Long, Integer> map, TreeNode root, int targetSum, long sum) {
        if (root == null) return;
        sum += root.val;
        res += map.getOrDefault(sum - targetSum, 0);
        map.put(sum, map.getOrDefault(sum, 0) + 1);
        helper(map, root.left, targetSum, sum);
        helper(map, root.right, targetSum, sum);
        map.put(sum, map.get(sum) - 1);
    }
}

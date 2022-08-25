package company.amazon.q800;

import model.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q863 {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode, Integer> map = new HashMap<>();
        findTarget(map, root, target);
        List<Integer> res = new ArrayList<>();
        dfs(res, map, root, k, 0);
        return res;
    }

    private void dfs(List<Integer> res, Map<TreeNode, Integer> map, TreeNode root, int k, int dist) {
        if (root == null) return;
        if (map.containsKey(root)) dist = map.get(root);
        if (dist == k) res.add(root.val);
        dfs(res, map, root.left, k, dist + 1);
        dfs(res, map, root.right, k, dist + 1);
    }

    private int findTarget(Map<TreeNode, Integer> map, TreeNode root, TreeNode target) {
        if (root == null) return -1;
        if (root == target) {
            map.put(root, 0);
            return 0;
        }
        int left = findTarget(map, root.left, target);
        if (left != -1) {
            map.put(root, left + 1);
            return left + 1;
        }
        int right = findTarget(map, root.right, target);
        if (right != -1) {
            map.put(root, right + 1);
            return right + 1;
        }
        return -1;
    }
}

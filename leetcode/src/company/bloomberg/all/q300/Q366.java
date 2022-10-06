package company.bloomberg.all.q300;

import model.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Q366 {
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(res, root);
        return res;
    }

    private int dfs(List<List<Integer>> res, TreeNode root) {
        if (root == null) return -1;
        int left = dfs(res, root.left);
        int right = dfs(res, root.right);
        int depth = Math.max(left, right) + 1;
        if (depth == res.size()) res.add(new ArrayList<>());
        res.get(depth).add(root.val);
        return depth;
    }
}

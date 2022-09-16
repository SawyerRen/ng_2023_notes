package company.amazon.finalround;

import model.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Q366 {
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        helper(res, root);
        return res;
    }

    private int helper(List<List<Integer>> res, TreeNode root) {
        if (root == null) return 0;
        int left = helper(res, root.left);
        int right = helper(res, root.right);
        int depth = Math.max(left, right);
        if (depth == res.size()) res.add(new ArrayList<>());
        res.get(depth).add(root.val);
        return depth + 1;
    }
}

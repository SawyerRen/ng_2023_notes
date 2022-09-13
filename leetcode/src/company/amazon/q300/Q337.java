package company.amazon.q300;

import model.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class Q337 {
    Map<TreeNode, Integer> memo = new HashMap<>();

    public int rob(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return root.val;
        if (memo.containsKey(root)) return memo.get(root);
        int res = root.val;
        if (root.left != null) res += rob(root.left.left) + rob(root.left.right);
        if (root.right != null) res += rob(root.right.left) + rob(root.right.right);
        res = Math.max(res, rob(root.left) + rob(root.right));
        memo.put(root, res);
        return res;
    }
}

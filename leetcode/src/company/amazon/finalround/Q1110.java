package company.amazon.finalround;

import model.TreeNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Q1110 {
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        Set<Integer> set = new HashSet<>();
        for (int i : to_delete) {
            set.add(i);
        }
        List<TreeNode> res = new ArrayList<>();
        helper(res, root, set);
        if (!set.contains(root.val)) {
            res.add(root);
        }
        return res;
    }

    private TreeNode helper(List<TreeNode> res, TreeNode root, Set<Integer> set) {
        if (root == null) return null;
        TreeNode left = helper(res, root.left, set);
        TreeNode right = helper(res, root.right, set);
        if (set.contains(root.val)) {
            if (left != null) res.add(left);
            if (right != null) res.add(right);
            return null;
        } else {
            root.left = left;
            root.right = right;
            return root;
        }
    }
}

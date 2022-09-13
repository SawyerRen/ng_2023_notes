package company.amazon.q1100;

import model.TreeNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Q1110 {
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> res = new ArrayList<>();
        Set<Integer> deleteSet = new HashSet<>();
        for (int i : to_delete) {
            deleteSet.add(i);
        }
        if (!deleteSet.contains(root.val)) res.add(root);
        helper(res, root, deleteSet);
        return res;
    }

    private TreeNode helper(List<TreeNode> res, TreeNode root, Set<Integer> deleteSet) {
        if (root == null) return null;
        TreeNode left = helper(res, root.left, deleteSet);
        TreeNode right = helper(res, root.right, deleteSet);
        if (deleteSet.contains(root.val)) {
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

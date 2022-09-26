package company.uber.all1;

import model.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Q226 {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        TreeNode left = root.left;
        root.left = root.right;
        root.right = left;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}

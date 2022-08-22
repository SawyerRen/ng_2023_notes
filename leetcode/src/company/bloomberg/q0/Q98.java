package company.bloomberg.q0;

import model.TreeNode;

import java.util.Stack;
import java.util.TreeMap;

public class Q98 {
    public boolean isValidBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (pre != null && pre.val >= root.val) return false;
            pre = root;
            root = root.right;
        }
        return true;
    }

    public boolean isValidBST1(TreeNode root) {
        return valid(root, null, null);
    }

    private boolean valid(TreeNode root, TreeNode minNode, TreeNode maxNode) {
        if (root == null) return true;
        if (minNode != null && root.val <= minNode.val) return false;
        if (maxNode != null && root.val >= maxNode.val) return false;
        return valid(root.left, minNode, root) && valid(root.right, root, maxNode);
    }
}

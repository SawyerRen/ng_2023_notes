package company.uber.lastround;

import model.TreeNode;

import java.util.Stack;

public class Q230 {
    public int kthLargest1(TreeNode root, int k) {
        while (root != null) {
            if (root.right == null) {
                k--;
                if (k == 0) return root.val;
                root = root.left;
            } else {
                TreeNode pre = root.right;
                while (pre.left != null) pre = pre.left;
                pre.left = root;
                TreeNode temp = root;
                root = root.right;
                temp.right = null;
            }
        }
        return -1;
    }

    public int kthLargest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.right;
            }
            root = stack.pop();
            k--;
            if (k == 0) return root.val;
            root = root.left;
        }
        return -1;
    }

    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            k--;
            if (k == 0) return root.val;
            root = root.right;
        }
        return -1;
    }

    public int kthSmallest1(TreeNode root, int k) {
        while (root != null) {
            if (root.left == null) {
                k--;
                if (k == 0) return root.val;
                root = root.right;
            } else {
                TreeNode pre = root.left;
                while (pre.right != null) {
                    pre = pre.right;
                }
                pre.right = root;
                TreeNode temp = root;
                root = root.left;
                temp.left = null;
            }
        }
        return -1;
    }
}

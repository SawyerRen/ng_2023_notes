package company.bloomberg.q400;

import model.TreeNode;

public class Q450 {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;
        if (root.val < key) {
            root.right = deleteNode(root.right, key);
        } else if (root.val > key) {
            root.left = deleteNode(root.left, key);
        } else {
            if (root.left == null) return root.right;
            if (root.right == null) return root.left;

            TreeNode right = root.right;
            while (right.left != null) {
                right = right.left;
            }
            root.val = right.val;
            root.right = deleteNode(root.right, root.val);
        }
        return root;
    }
}

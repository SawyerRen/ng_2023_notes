package company.uber.all1;

import model.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Q545 {
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        res.add(root.val);
        left(root.left, res);
        leaves(root.left, res);
        leaves(root.right, res);
        LinkedList<Integer> right = new LinkedList<>();
        findRight(root.right, right);
        res.addAll(right);
        return res;
    }

    private void findRight(TreeNode node, LinkedList<Integer> list) {
        if (node == null) return;
        if (node.left == null && node.right == null) return;
        list.addFirst(node.val);
        if (node.right != null) findRight(node.right, list);
        else findRight(node.left, list);
    }

    private void leaves(TreeNode root, List<Integer> res) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            res.add(root.val);
            return;
        }
        leaves(root.left, res);
        leaves(root.right, res);
    }

    private void left(TreeNode left, List<Integer> res) {
        if (left == null) return;
        if (left.left == null && left.right == null) return;
        res.add(left.val);
        if (left.left != null) left(left.left, res);
        else left(left.right, res);
    }
}

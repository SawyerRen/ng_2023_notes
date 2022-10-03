package company.uber.lastround;

import model.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Q545 {
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        res.add(root.val);
        leftBound(res, root.left);
        findLeaves(res, root.left);
        findLeaves(res, root.right);
        LinkedList<Integer> right = new LinkedList<>();
        rightBound(right, root.right);
        res.addAll(right);
        return res;
    }

    private void rightBound(LinkedList<Integer> right, TreeNode node) {
        if (node == null) return;
        if (node.left == null && node.right == null) return;
        right.addFirst(node.val);
        if (node.right != null) {
            rightBound(right, node.right);
        } else {
            rightBound(right, node.left);
        }
    }

    private void findLeaves(List<Integer> res, TreeNode node) {
        if (node == null) return;
        if (node.left == null && node.right == null) {
            res.add(node.val);
            return;
        }
        findLeaves(res, node.left);
        findLeaves(res, node.right);
    }

    private void leftBound(List<Integer> res, TreeNode left) {
        if (left == null) return;
        if (left.left == null && left.right == null) return;
        res.add(left.val);
        if (left.left != null) {
            leftBound(res, left.left);
        } else {
            leftBound(res, left.right);
        }
    }
}

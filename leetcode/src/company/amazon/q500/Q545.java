package company.amazon.q500;

import model.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Q545 {
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        res.add(root.val);
        findLeft(res, root.left);
        findBottom(res, root.left);
        findBottom(res, root.right);
        LinkedList<Integer> rightList = new LinkedList<>();
        findRight(rightList, root.right);
        res.addAll(rightList);
        return res;
    }

    private void findBottom(List<Integer> res, TreeNode node) {
        if (node == null) return;
        if (node.left == null && node.right == null) {
            res.add(node.val);
            return;
        }
        findBottom(res, node.left);
        findBottom(res, node.right);
    }

    private void findLeft(List<Integer> res, TreeNode node) {
        if (node == null) return;
        if (node.left == null && node.right == null) return;
        res.add(node.val);
        if (node.left != null) findLeft(res, node.left);
        else findLeft(res, node.right);
    }

    private void findRight(LinkedList<Integer> res, TreeNode node) {
        if (node == null) return;
        if (node.left == null && node.right == null) return;
        res.addFirst(node.val);
        if (node.right != null) findRight(res, node.right);
        else findRight(res, node.left);
    }
}

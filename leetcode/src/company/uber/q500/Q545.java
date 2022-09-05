package company.uber.q500;

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
        addLeaves(res, root.left);
        addLeaves(res, root.right);
        LinkedList<Integer> rightList = new LinkedList<>();
        rightBound(rightList, root.right);
        res.addAll(rightList);
        return res;
    }

    private void rightBound(LinkedList<Integer> list, TreeNode root) {
        if (root == null) return;
        if (root.left == null && root.right == null) return;
        list.addFirst(root.val);
        if (root.right != null) rightBound(list, root.right);
        else rightBound(list, root.left);
    }

    private void addLeaves(List<Integer> res, TreeNode root) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            res.add(root.val);
            return;
        }
        addLeaves(res, root.left);
        addLeaves(res, root.right);
    }

    private void leftBound(List<Integer> res, TreeNode root) {
        if (root == null) return;
        if (root.left == null && root.right == null) return;
        res.add(root.val);
        if (root.left != null) {
            leftBound(res, root.left);
        } else {
            leftBound(res, root.right);
        }
    }
}

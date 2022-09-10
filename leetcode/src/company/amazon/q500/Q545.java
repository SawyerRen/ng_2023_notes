package company.amazon.q500;

import model.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Q545 {
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        res.add(root.val);
        leftBound(res, root.left);
        findLeaves(res, root.left);
        findLeaves(res, root.right);
        LinkedList<Integer> rightList = new LinkedList<>();
        rightBound(rightList, root.right);
        res.addAll(rightList);
        return res;
    }

    private void rightBound(LinkedList<Integer> rightList, TreeNode root) {
        if (root == null) return;
        if (root.left == null && root.right == null) return;
        rightList.addFirst(root.val);
        if (root.right != null) rightBound(rightList, root.right);
        else rightBound(rightList, root.left);
    }

    private void findLeaves(List<Integer> res, TreeNode root) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            res.add(root.val);
            return;
        }
        findLeaves(res, root.left);
        findLeaves(res, root.right);
    }

    private void leftBound(List<Integer> res, TreeNode root) {
        if (root == null) return;
        if (root.left == null && root.right == null) return;
        res.add(root.val);
        if (root.left != null) leftBound(res, root.left);
        else leftBound(res, root.right);
    }
}

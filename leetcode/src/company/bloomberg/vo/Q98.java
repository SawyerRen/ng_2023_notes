package company.bloomberg.vo;

import model.TreeNode;

import java.util.Stack;

public class Q98 {
    public boolean isValidBST(TreeNode root) {
        TreeNode pre = null;
        if (root == null) return true;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (!stack.isEmpty() || cur != null) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            if (pre != null && pre.val >= cur.val) return false;
            pre = cur;
            cur = cur.right;
        }
        return true;
    }
}

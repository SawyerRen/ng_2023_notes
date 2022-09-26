package company.uber.all1;

import model.TreeNode;

import java.util.Stack;

public class Q98 {
    public boolean isValidBST(TreeNode root) {
        TreeNode pre = null;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (!stack.isEmpty() || cur != null) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            if (pre != null && cur.val <= pre.val) return false;
            pre = cur;
            cur = cur.right;
        }
        return true;
    }
}

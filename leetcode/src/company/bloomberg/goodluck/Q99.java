package company.bloomberg.goodluck;

import model.TreeNode;

import java.util.Stack;

public class Q99 {
    public void recoverTree(TreeNode root) {
        TreeNode n1 = null, n2 = null;
        TreeNode pre = null, cur = root;
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || cur != null) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            if (pre != null && pre.val > cur.val) {
                n1 = n1 == null ? pre : n1;
                n2 = cur;
            }
            pre = cur;
            cur = cur.right;
        }
        int v = n1.val;
        n1.val = n2.val;
        n2.val = v;
    }
}

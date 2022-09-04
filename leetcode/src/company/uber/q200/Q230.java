package company.uber.q200;

import model.TreeNode;

import java.util.Stack;

public class Q230 {
    int count = 0, res = 0;

    public int kthSmallest(TreeNode root, int k) {
        dfs(root, k);
        return res;
    }

    private void dfs(TreeNode root, int k) {
        if (root == null) return;
        dfs(root.left, k);
        count++;
        if (count == k) {
            res = root.val;
            return;
        }
        dfs(root.right, k);
    }

    public int kthSmallest1(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            k--;
            if (k == 0) return cur.val;
            cur = cur.right;
        }
        return -1;
    }
}

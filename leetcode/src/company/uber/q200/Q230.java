package company.uber.q200;

import model.TreeNode;

import java.util.Stack;
import java.util.TreeMap;

public class Q230 {
    class Result {
        int count;
        int val;
    }

    public int kthSmallest(TreeNode root, int k) {
        Result result = new Result();
        dfs(root, k, result);
        return result.val;
    }

    private void dfs(TreeNode root, int k, Result result) {
        if (root == null) return;
        dfs(root.left, k, result);
        result.count++;
        if (result.count == k) result.val = root.val;
        dfs(root.right, k, result);
    }

    public int kthSmallest4(TreeNode root, int k) {
        while (root != null) {
            if (root.left == null) {
                k--;
                if (k == 0) return root.val;
                root = root.right;
            } else {
                TreeNode pre = root.left;
                while (pre.right != null) {
                    pre = pre.right;
                }
                pre.right = root;
                TreeNode temp = root;
                root = root.left;
                temp.left = null;
            }
        }
        return -1;
    }

    public int kthSmallest1(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (!stack.isEmpty() || cur != null) {
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

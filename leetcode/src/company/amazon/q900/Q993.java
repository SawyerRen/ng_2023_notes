package company.amazon.q900;

import model.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Q993 {
    public boolean isCousins(TreeNode root, int x, int y) {
        if (root == null) return false;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean findX = false, findY = false;
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if (poll.left != null && poll.left.val == x && poll.right != null && poll.right.val == y) return false;
                if (poll.left != null && poll.left.val == y && poll.right != null && poll.right.val == x) return false;
                if (poll.left != null && poll.left.val == x || poll.right != null && poll.right.val == x) findX = true;
                if (poll.left != null && poll.left.val == y || poll.right != null && poll.right.val == y) findY = true;
                if (poll.left != null) queue.add(poll.left);
                if (poll.right != null) queue.add(poll.right);
            }
            if (findX && findY) return true;
            if (findX || findY) return false;
        }
        return false;
    }
}

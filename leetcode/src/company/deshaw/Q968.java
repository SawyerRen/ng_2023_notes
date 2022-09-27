package company.deshaw;

import model.TreeNode;

public class Q968 {
    int unMonitored = 1;
    int MonitoredWithCamera = 2;
    int MonitoredWithoutCamera = 3;
    int res = 0;

    public int minCameraCover(TreeNode root) {
        int top = helper(root);
        if (top == unMonitored) res++;
        return res;
    }

    private int helper(TreeNode root) {
        if (root == null) return MonitoredWithoutCamera;
        int left = helper(root.left);
        int right = helper(root.right);
        if (left == MonitoredWithoutCamera && right == MonitoredWithoutCamera) {
            return unMonitored;
        } else if (left == unMonitored || right == unMonitored) {
            res++;
            return MonitoredWithCamera;
        } else {
            return MonitoredWithoutCamera;
        }
    }
}

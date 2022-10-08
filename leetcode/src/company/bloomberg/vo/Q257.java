package company.bloomberg.vo;

import model.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Q257 {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        helper(res, new StringBuilder(), root);
        return res;
    }

    private void helper(List<String> res, StringBuilder builder, TreeNode root) {
        if (root == null) return;
        int len = builder.length();
        if (builder.length() == 0) {
            builder.append(root.val);
        } else {
            builder.append("->").append(root.val);
        }
        if (root.left == null && root.right == null) {
            res.add(builder.toString());
        } else {
            helper(res, builder, root.left);
            helper(res, builder, root.right);
        }
        builder.setLength(len);
    }
}

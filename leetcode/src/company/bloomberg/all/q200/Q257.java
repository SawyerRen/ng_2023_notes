package company.bloomberg.all.q200;

import model.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Q257 {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        StringBuilder builder = new StringBuilder();
        dfs(res, builder, root);
        return res;
    }

    private void dfs(List<String> res, StringBuilder builder, TreeNode root) {
        if (root == null) return;
        int len = builder.length();
        if (builder.length() == 0) builder.append(root.val);
        else builder.append("->").append(root.val);
        if (root.left == null && root.right == null) {
            res.add(builder.toString());
            builder.setLength(len);
            return;
        }
        dfs(res, builder, root.left);
        dfs(res, builder, root.right);
        builder.setLength(len);
    }
}

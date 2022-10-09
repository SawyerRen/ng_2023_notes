package company.bloomberg.r2;

import model.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class Q105 {
    int preIndex = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return helper(preorder, map, 0, inorder.length - 1);
    }

    private TreeNode helper(int[] preorder, Map<Integer, Integer> map, int left, int right) {
        if (preIndex >= preorder.length) return null;
        if (left > right) return null;
        int val = preorder[preIndex++];
        Integer inIndex = map.get(val);
        TreeNode root = new TreeNode(val);
        root.left = helper(preorder, map, left, inIndex - 1);
        root.right = helper(preorder, map, inIndex + 1, right);
        return root;
    }
}

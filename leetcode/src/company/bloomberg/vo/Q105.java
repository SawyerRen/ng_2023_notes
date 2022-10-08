package company.bloomberg.vo;

import model.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class Q105 {
    Map<Integer, Integer> map = new HashMap<>();
    int preIndex = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return helper(map, preorder, 0, inorder.length - 1);
    }

    private TreeNode helper(Map<Integer, Integer> map, int[] preorder, int left, int right) {
        if (preIndex >= preorder.length) return null;
        if (left > right) return null;
        int rootVal = preorder[preIndex++];
        int inIndex = map.get(rootVal);
        TreeNode root = new TreeNode(rootVal);
        root.left = helper(map, preorder, left, inIndex - 1);
        root.right = helper(map, preorder, inIndex + 1, right);
        return root;
    }
}

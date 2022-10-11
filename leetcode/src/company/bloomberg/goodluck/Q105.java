package company.bloomberg.goodluck;

import model.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class Q105 {
    Map<Integer, Integer> map = new HashMap<>();
    int index = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return helper(map, preorder, 0, inorder.length - 1);
    }

    private TreeNode helper(Map<Integer, Integer> map, int[] preorder, int left, int right) {
        if (index >= preorder.length) return null;
        if (left > right) return null;
        int val = preorder[index++];
        int index = map.get(val);
        TreeNode root = new TreeNode(val);
        root.left = helper(map, preorder, left, index - 1);
        root.right = helper(map, preorder, index + 1, right);
        return root;
    }
}

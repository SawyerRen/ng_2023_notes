package company.bloomberg.q100;

import model.TreeNode;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Q105 {
    Map<Integer, Integer> map = new HashMap<>();
    int index = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return helper(preorder, 0, preorder.length - 1);
    }

    private TreeNode helper(int[] preorder, int left, int right) {
        if (left > right) return null;
        int val = preorder[index++];
        Integer inorderIndex = map.get(val);
        TreeNode root = new TreeNode(val);
        root.left = helper(preorder, left, inorderIndex - 1);
        root.right = helper(preorder, inorderIndex + 1, right);
        return root;
    }
}

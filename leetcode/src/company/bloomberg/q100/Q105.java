package company.bloomberg.q100;

import model.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class Q105 {
    int preIndex = 0;
    Map<Integer, Integer> inorderMap = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        return helper(preorder, 0, inorder.length - 1);
    }

    private TreeNode helper(int[] preorder, int left, int right) {
        if (left > right) return null;
        int rootVal = preorder[preIndex++];
        Integer inorderIndex = inorderMap.get(rootVal);
        TreeNode root = new TreeNode(rootVal);
        root.left = helper(preorder, left, inorderIndex - 1);
        root.right = helper(preorder, inorderIndex + 1, right);
        return root;
    }
}

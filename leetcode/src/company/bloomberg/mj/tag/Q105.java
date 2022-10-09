package company.bloomberg.mj.tag;

import model.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class Q105 {
    int preIndex = 0;
    Map<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return helper(preorder, 0, inorder.length - 1);
    }

    private TreeNode helper(int[] preorder, int left, int right) {
        if (preIndex >= preorder.length) return null;
        if (right < left) return null;
        int rootVal = preorder[preIndex++];
        Integer inIndex = map.get(rootVal);
        TreeNode root = new TreeNode(rootVal);
        root.left = helper(preorder, left, inIndex - 1);
        root.right = helper(preorder, inIndex + 1, right);
        return root;
    }
}

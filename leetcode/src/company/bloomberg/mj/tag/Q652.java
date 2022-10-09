package company.bloomberg.mj.tag;

import model.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q652 {
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        Map<String, List<TreeNode>> map = new HashMap<>();
        helper(map, root);
        List<TreeNode> res = new ArrayList<>();
        for (List<TreeNode> list : map.values()) {
            if (list.size() > 1) res.add(list.get(0));
        }
        return res;
    }

    private String helper(Map<String, List<TreeNode>> map, TreeNode root) {
        if (root == null) {
            return "null";
        }
        String s = root.val + ","+helper(map, root.left) + ","+helper(map, root.right);
        map.putIfAbsent(s, new ArrayList<>());
        map.get(s).add(root);
        return s;
    }
}

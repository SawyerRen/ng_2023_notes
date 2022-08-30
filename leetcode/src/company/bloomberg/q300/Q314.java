package company.bloomberg.q300;

import model.TreeNode;

import java.util.*;

public class Q314 {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        Queue<TreeNode> nodes = new LinkedList<>();
        Queue<Integer> cols = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        nodes.add(root);
        cols.add(0);
        int min = 0, max = 0;
        Map<Integer, List<Integer>> map = new HashMap<>();
        while (!nodes.isEmpty()) {
            TreeNode node = nodes.poll();
            Integer col = cols.poll();
            min = Math.min(min, col);
            max = Math.max(max, col);
            map.putIfAbsent(col, new ArrayList<>());
            map.get(col).add(node.val);
            if (node.left != null) {
                nodes.add(node.left);
                cols.add(col - 1);
            }
            if (node.right != null) {
                nodes.add(node.right);
                cols.add(col + 1);
            }
        }
        for (int i = min; i <= max; i++) {
            res.add(map.get(i));
        }
        return res;
    }
}

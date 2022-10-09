package company.bloomberg.mj.tag;

import javafx.util.Pair;
import model.TreeNode;

import java.util.*;

public class Q314 {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        queue.add(new Pair<>(root, 0));
        int min = 0, max = 0;
        while (!queue.isEmpty()) {
            Pair<TreeNode, Integer> poll = queue.poll();
            TreeNode node = poll.getKey();
            int col = poll.getValue();
            min = Math.min(min, col);
            max = Math.max(max, col);
            map.putIfAbsent(col, new ArrayList<>());
            map.get(col).add(node.val);
            if (node.left != null) queue.add(new Pair<>(node.left, col - 1));
            if (node.right != null) queue.add(new Pair<>(node.right, col + 1));
        }
        List<List<Integer>> res = new ArrayList<>();
        for (int i = min; i < max + 1; i++) {
            res.add(map.get(i));
        }
        return res;
    }
}

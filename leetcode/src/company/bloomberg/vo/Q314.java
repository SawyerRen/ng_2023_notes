package company.bloomberg.vo;

import javafx.util.Pair;
import model.TreeNode;

import java.util.*;

public class Q314 {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        queue.add(new Pair<>(root, 0));
        int min = 0, max = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Pair<TreeNode, Integer> poll = queue.poll();
                TreeNode node = poll.getKey();
                Integer col = poll.getValue();
                min = Math.min(col, min);
                max = Math.max(max, col);
                map.putIfAbsent(col, new ArrayList<>());
                map.get(col).add(node.val);
                if (node.left != null) queue.add(new Pair<>(node.left, col - 1));
                if (node.right != null) queue.add(new Pair<>(node.right, col + 1));
            }
        }
        for (int i = min; i <= max; i++) {
            res.add(map.get(i));
        }
        return res;
    }
}

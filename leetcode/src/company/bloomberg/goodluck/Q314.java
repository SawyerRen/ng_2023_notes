package company.bloomberg.goodluck;

import javafx.util.Pair;
import model.TreeNode;

import java.util.*;

public class Q314 {
    // 这道题用BFS，Queue里面保存节点和对应的column值，遍历到一个节点，它的左节点的column就是column-1，右边就是column+1
    public List<List<Integer>> verticalOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();
        Map<Integer, List<Integer>> map = new HashMap<>(); // 存一个column值和对应的节点的值list
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>(); // 在BFS过程中存Pair<节点，对应的column>
        queue.add(new Pair<>(root, 0)); // root节点的column值为0
        int min = 0, max = 0; // min和max是这个树的column最小和最大值
        while (!queue.isEmpty()) {
            // 从queue中取出节点和column值
            Pair<TreeNode, Integer> poll = queue.poll();
            TreeNode node = poll.getKey();
            int col = poll.getValue();
            // 将这个node的值存到map对应column值的list中
            map.putIfAbsent(col, new ArrayList<>());
            map.get(col).add(node.val);
            // 更新column最小和最大值
            min = Math.min(min, col);
            max = Math.max(max, col);
            // 将左右节点加入queue中，左节点的col就是col-1，右边就是col+1
            if (node.left != null) {
                queue.add(new Pair<>(node.left, col - 1));
            }
            if (node.right != null) {
                queue.add(new Pair<>(node.right, col + 1));
            }
        }
        // 将map中每个column值对应的list加入res中
        List<List<Integer>> res = new ArrayList<>();
        for (int i = min; i <= max; i++) {
            res.add(map.get(i));
        }
        return res;
    }
}

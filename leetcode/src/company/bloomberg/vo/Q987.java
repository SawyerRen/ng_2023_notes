package company.bloomberg.vo;

import javafx.util.Pair;
import model.TreeNode;

import java.util.*;

public class Q987 {
    class Node {
        int row;
        int col;
        int value;

        public Node(int row, int col, int value) {
            this.row = row;
            this.col = col;
            this.value = value;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Map<Integer, List<Node>> map = new HashMap<>();
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        queue.add(new Pair<>(root, 0));
        int row = 0;
        int min = 0, max = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Pair<TreeNode, Integer> pair = queue.poll();
                TreeNode node = pair.getKey();
                int col = pair.getValue();
                min = Math.min(min, col);
                max = Math.max(max, col);
                map.putIfAbsent(col, new ArrayList<>());
                map.get(col).add(new Node(row, col, node.val));
                if (node.left != null) {
                    queue.add(new Pair<>(node.left, col - 1));
                }
                if (node.right != null) {
                    queue.add(new Pair<>(node.right, col + 1));
                }
            }
            row++;
        }
        for (int i = min; i <= max; i++) {
            List<Node> nodes = map.get(i);
            nodes.sort((a, b) -> a.row == b.row ? a.value - b.value : a.row - b.row);
            List<Integer> list = new ArrayList<>();
            for (Node node : nodes) {
                list.add(node.value);
            }
            res.add(list);
        }
        return res;
    }
}

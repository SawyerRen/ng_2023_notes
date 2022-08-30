package company.bloomberg.q900;

import model.TreeNode;

import java.util.*;

public class Q987 {
    class Node {
        int row;
        int col;
        int val;

        public Node(int row, int col, int val) {
            this.row = row;
            this.col = col;
            this.val = val;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Map<Integer, List<Node>> map = new HashMap<>();
        int min = 0, max = 0;
        Queue<TreeNode> nodes = new LinkedList<>();
        Queue<Integer> cols = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        nodes.add(root);
        cols.add(0);
        int row = 0;
        while (!nodes.isEmpty()) {
            int size = nodes.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = nodes.poll();
                int col = cols.poll();
                min = Math.min(col, min);
                max = Math.max(max, col);
                map.putIfAbsent(col, new ArrayList<>());
                map.get(col).add(new Node(row, col, poll.val));
                if (poll.left != null) {
                    nodes.add(poll.left);
                    cols.add(col - 1);
                }
                if (poll.right != null) {
                    nodes.add(poll.right);
                    cols.add(col + 1);
                }
            }
            row++;
        }
        for (int i = min; i < max + 1; i++) {
            List<Node> nodeList = map.get(i);
            nodeList.sort((a, b) -> a.row == b.row ? a.val - b.val : a.row - b.row);
            List<Integer> list = new ArrayList<>();
            for (Node node : nodeList) {
                list.add(node.val);
            }
            res.add(list);
        }
        return res;
    }
}

package company.bloomberg.vo;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

public class Q1029 {
    class Node {
        int index;
        int diff;

        public Node(int index, int diff) {
            this.index = index;
            this.diff = diff;
        }
    }

    public int twoCitySchedCost(int[][] costs) {
        List<Node> list = new ArrayList<>();
        for (int i = 0; i < costs.length; i++) {
            list.add(new Node(i, costs[i][0] - costs[i][1]));
        }
        list.sort((a, b) -> a.diff - b.diff);
        int res = 0;
        for (int i = 0; i < list.size() / 2; i++) {
            Node node = list.get(i);
            res += costs[node.index][0];
        }
        for (int i = list.size() / 2; i < list.size(); i++) {
            Node node = list.get(i);
            res += costs[node.index][1];
        }
        return res;
    }
}

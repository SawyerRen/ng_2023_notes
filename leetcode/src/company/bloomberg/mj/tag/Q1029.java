package company.bloomberg.mj.tag;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

public class Q1029 {
    public int twoCitySchedCost(int[][] costs) {
        List<Pair<Integer, Integer>> list = new ArrayList<>();
        for (int i = 0; i < costs.length; i++) {
            list.add(new Pair<>(i, costs[i][0] - costs[i][1]));
        }
        list.sort((a, b) -> a.getValue() - b.getValue());
        int res = 0;
        for (int i = 0; i < list.size() / 2; i++) {
            res += costs[list.get(i).getKey()][0];
        }
        for (int i = list.size() / 2; i < list.size(); i++) {
            res += costs[list.get(i).getKey()][1];
        }
        return res;
    }
}

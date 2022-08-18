package company.bloomberg.q1000;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

public class Q1029 {
    public int twoCitySchedCost(int[][] costs) {
        int n = costs.length;
        List<Pair<Integer, Integer>> diff = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            diff.add(new Pair<>(i, costs[i][0] - costs[i][1]));
        }
        diff.sort((a, b) -> a.getValue() - b.getValue());
        int res = 0;
        for (int i = 0; i < n; i++) {
            int index = diff.get(i).getKey();
            if (i < n / 2) res += costs[index][0];
            else res += costs[index][1];
        }
        return res;
    }
}

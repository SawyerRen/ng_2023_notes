package company.bloomberg.goodluck;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q1029 {
    // O(nlogn)
    public int twoCitySchedCost1(int[][] costs) {
        List<Pair<Integer, Integer>> list = new ArrayList<>();
        for (int i = 0; i < costs.length; i++) {
            list.add(new Pair<>(costs[i][0] - costs[i][1], i));
        }
        list.sort((a, b) -> a.getKey() - b.getKey());
        int res = 0;
        for (int i = 0; i < list.size() / 2; i++) {
            int index = list.get(i).getValue();
            res += costs[index][0];
        }
        for (int i = list.size() / 2; i < list.size(); i++) {
            int index = list.get(i).getValue();
            res += costs[index][1];
        }
        return res;
    }

    public int twoCitySchedCost(int[][] costs) {
        Arrays.sort(costs, (a, b) -> {
            int diff1 = a[0] - a[1];
            int diff2 = b[0] - b[1];
            return diff1 - diff2;
        });
        int res = 0;
        for (int i = 0; i < costs.length / 2; i++) {
            res += costs[i][0];
        }
        for (int i = costs.length / 2; i < costs.length; i++) {
            res += costs[i][1];
        }
        return res;
    }
}

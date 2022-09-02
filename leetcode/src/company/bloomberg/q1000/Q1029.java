package company.bloomberg.q1000;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q1029 {
    public int twoCitySchedCost(int[][] costs) {
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < costs.length; i++) {
            list.add(new int[]{i, costs[i][0] - costs[i][1]});
        }
        list.sort((a, b) -> a[1] - b[1]);
        int res = 0;
        for (int i = 0; i < list.size() / 2; i++) {
            res += costs[list.get(i)[0]][0];
        }
        for (int i = list.size() / 2; i < list.size(); i++) {
            res += costs[list.get(i)[0]][1];
        }
        return res;
    }
}

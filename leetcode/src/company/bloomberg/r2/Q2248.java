package company.bloomberg.r2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q2248 {
    public List<Integer> intersection(int[][] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] num : nums) {
            for (int i : num) {
                map.put(i, map.getOrDefault(i, 0) + 1);
            }
        }
        List<Integer> res = new ArrayList<>();
        for (Integer i : map.keySet()) {
            if (map.get(i) == nums.length) res.add(i);
        }
        res.sort((a, b) -> a - b);
        return res;
    }
}

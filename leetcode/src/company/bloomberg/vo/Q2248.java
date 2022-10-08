package company.bloomberg.vo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q2248 {
    public List<Integer> intersection(int[][] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] arr : nums) {
            for (int i : arr) {
                map.put(i, map.getOrDefault(i, 0) + 1);
            }
        }
        List<Integer> res = new ArrayList<>();
        for (Integer num : map.keySet()) {
            if (map.get(num) == nums.length) res.add(num);
        }
        res.sort((a, b) -> a - b);
        return res;
    }
}

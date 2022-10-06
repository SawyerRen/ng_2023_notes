package company.bloomberg.all.other;

import java.util.HashMap;
import java.util.Map;

public class CountPairsWithGivenSum {
    int countPairs(int[] nums, int targetSum) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int count = 0;
        for (Integer num : map.keySet()) {
            if (map.containsKey(targetSum - num)) {
                count += map.get(targetSum - num);
            }
            if (num + num == targetSum) count--;
        }
        return count / 2;
    }
}

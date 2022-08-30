package company.bloomberg.other;

import java.util.HashMap;
import java.util.Map;

public class CountPairsWithGivenSum {
    int countPairs(int[] nums, int targetSum) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int count = 0;
        for (int num : nums) {
            count += map.getOrDefault(targetSum - num, 0);
            if (num + num == targetSum) count--;
        }
        return count / 2;
    }
}

package company.uber.q900;

import java.util.HashMap;
import java.util.Map;

public class Q930 {
    public int numSubarraysWithSum(int[] nums, int goal) {
        Map<Integer, Integer> map = new HashMap<>();
        int preSum = 0, res = 0;
        map.put(0, 1);
        for (int num : nums) {
            preSum += num;
            res += map.getOrDefault(preSum - goal, 0);
            map.put(preSum, map.getOrDefault(preSum, 0) + 1);
        }
        return res;
    }
}

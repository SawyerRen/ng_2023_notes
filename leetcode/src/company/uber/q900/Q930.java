package company.uber.q900;

import java.util.HashMap;
import java.util.Map;

public class Q930 {
    public int numSubarraysWithSum(int[] nums, int goal) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum = 0, res = 0;
        for (int num : nums) {
            sum += num;
            res += map.getOrDefault(sum - goal, 0);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return res;
    }
}

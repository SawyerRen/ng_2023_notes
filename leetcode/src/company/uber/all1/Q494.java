package company.uber.all1;

import java.util.HashMap;
import java.util.Map;

public class Q494 {
    public int findTargetSumWays(int[] nums, int target) {
        Map<String, Integer> memo = new HashMap<>();
        return helper(memo, nums, 0, target);
    }

    private int helper(Map<String, Integer> memo, int[] nums, int index, int target) {
        if (index == nums.length) {
            if (0 == target) return 1;
            return 0;
        }
        String state = index + "." + target;
        if (memo.containsKey(state)) return memo.get(state);
        int res = 0;
        res += helper(memo, nums, index + 1, target - nums[index]);
        res += helper(memo, nums, index + 1, target + nums[index]);
        memo.put(state, res);
        return res;
    }
}

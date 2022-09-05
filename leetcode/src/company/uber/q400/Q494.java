package company.uber.q400;

import java.util.HashMap;
import java.util.Map;

public class Q494 {
    public int findTargetSumWays(int[] nums, int target) {
        Map<String, Integer> memo = new HashMap<>();
        return helper(memo, nums, target, 0, 0);
    }

    private int helper(Map<String, Integer> memo, int[] nums, int target, int index, int sum) {
        if (index == nums.length) {
            if (sum == target) return 1;
            return 0;
        }
        String state = index + "," + sum;
        if (memo.containsKey(state)) return memo.get(state);
        int res = 0;
        res += helper(memo, nums, target, index + 1, sum + nums[index]);
        res += helper(memo, nums, target, index + 1, sum - nums[index]);
        memo.put(state, res);
        return res;
    }
}

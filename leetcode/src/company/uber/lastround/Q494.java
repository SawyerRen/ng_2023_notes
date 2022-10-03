package company.uber.lastround;

import java.util.HashMap;
import java.util.Map;

public class Q494 {
    public int findTargetSumWays(int[] nums, int target) {
        Map<String, Integer> memo = new HashMap<>();
        return helper(nums, 0, 0, target, memo);
    }

    private int helper(int[] nums, int index, int cur, int target, Map<String, Integer> memo) {
        if (index == nums.length) {
            if (cur == target) return 1;
            return 0;
        }
        String s = index + ";" + cur;
        if (memo.containsKey(s)) return memo.get(s);
        int res = 0;
        res += helper(nums, index + 1, cur + nums[index], target, memo);
        res += helper(nums, index + 1, cur - nums[index], target, memo);
        memo.put(s, res);
        return res;
    }
}

package company.uber.lastround;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Q698 {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int total = 0;
        for (int num : nums) {
            total += num;
        }
        if (total % k != 0) return false;
        boolean[] visited = new boolean[nums.length];
        Map<String, Boolean> memo = new HashMap<>();
        return helper(memo, nums, visited, 0, total / k, 0, k);
    }

    private boolean helper(Map<String, Boolean> memo, int[] nums, boolean[] visited, int curSum, int target, int count, int k) {
        if (count == k) return true;
        if (curSum > target) return false;
        String s = Arrays.toString(visited);
        if (memo.containsKey(s)) return memo.get(s);
        if (curSum == target) {
            boolean res = helper(memo, nums, visited, 0, target, count + 1, k);
            memo.put(s, res);
            return res;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            if (helper(memo, nums, visited, curSum + nums[i], target, count, k)) {
                memo.put(s, true);
                return true;
            }
            visited[i] = false;
        }
        memo.put(s, false);
        return false;
    }
}

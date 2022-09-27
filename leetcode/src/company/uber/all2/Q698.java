package company.uber.all2;

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
        total /= k;
        Map<String, Boolean> memo = new HashMap<>();
        return helper(memo, nums, total, 0, 0, k, new boolean[nums.length]);
    }

    private boolean helper(Map<String, Boolean> memo, int[] nums, int sum, int curSum, int count, int k, boolean[] visited) {
        if (count == k) return true;
        if (curSum > sum) return false;
        String s = Arrays.toString(visited);
        if (memo.containsKey(s)) return memo.get(s);
        if (curSum == sum) {
            boolean res = helper(memo, nums, sum, 0, count + 1, k, visited);
            memo.put(s, res);
            return res;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            if (helper(memo, nums, sum, curSum + nums[i], count, k, visited)) {
                memo.put(s, true);
                return true;
            }
            visited[i] = false;
        }
        memo.put(s, false);
        return false;
    }
}

package company.uber.all1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Q698 {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % k != 0) return false;
        sum /= k;
        Map<String, Boolean> memo = new HashMap<>();
        return helper(memo, nums, sum, 0, k, new boolean[nums.length]);
    }

    private boolean helper(Map<String, Boolean> memo, int[] nums, int sum, int curSum, int k, boolean[] visited) {
        if (k == 0) return true;
        if (curSum > sum) return false;
        String s = Arrays.toString(visited);
        if (memo.containsKey(s)) return memo.get(s);
        if (curSum == sum) {
            boolean res = helper(memo, nums, sum, 0, k - 1, visited);
            memo.put(s, res);
            return res;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            if (helper(memo, nums, sum, curSum + nums[i], k, visited)) {
                memo.put(s, true);
                return true;
            }
            visited[i] = false;
        }
        memo.put(s, false);
        return false;
    }
}

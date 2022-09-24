package company.mathwork.oa;

import java.util.Deque;
import java.util.LinkedList;

public class SumAsYouGo {
    public int maxResult(int[] nums, int k) {
        Deque<Integer> list = new LinkedList<>();
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        list.addLast(0);
        for (int i = 1; i < nums.length; i++) {
            while (!list.isEmpty() && list.getFirst() < i - k) {
                list.removeFirst();
            }
            dp[i] = nums[i] + dp[list.getFirst()];
            while (!list.isEmpty() && dp[i] >= dp[list.getLast()]) {
                list.removeLast();
            }
            list.addLast(i);
        }
        return dp[nums.length - 1];
    }
}

package company.uber.q1400;

import java.util.Deque;
import java.util.LinkedList;

public class Q1438 {
    public int longestSubarray(int[] nums, int limit) {
        Deque<Integer> maxQueue = new LinkedList<>();
        Deque<Integer> minQueue = new LinkedList<>();
        int res = 0, i = 0, j = 0;
        while (j < nums.length) {
            while (!maxQueue.isEmpty() && nums[j] > maxQueue.getLast()) {
                maxQueue.pollLast();
            }
            maxQueue.addLast(nums[j]);
            while (!minQueue.isEmpty() && nums[j] < minQueue.getLast()) {
                minQueue.pollLast();
            }
            minQueue.addLast(nums[j]);
            while (maxQueue.peekFirst() - minQueue.peekFirst() > limit) {
                if (nums[i] == maxQueue.peekFirst()) maxQueue.pollFirst();
                if (nums[i] == minQueue.peekFirst()) minQueue.pollFirst();
                i++;
            }
            res = Math.max(res, j - i + 1);
            j++;
        }
        return res;
    }
}

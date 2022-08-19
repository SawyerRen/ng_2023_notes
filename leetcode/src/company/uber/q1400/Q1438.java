package company.uber.q1400;

import java.util.Deque;
import java.util.LinkedList;

public class Q1438 {
    public int longestSubarray(int[] nums, int limit) {
        Deque<Integer> minQueue = new LinkedList<>();
        Deque<Integer> maxQueue = new LinkedList<>();
        int i = 0, j = 0, res = 0;
        while (j < nums.length) {
            while (!minQueue.isEmpty() && nums[j] < minQueue.getLast()) {
                minQueue.removeLast();
            }
            minQueue.addLast(nums[j]);
            while (!maxQueue.isEmpty() && nums[j] > maxQueue.getLast()) {
                maxQueue.removeLast();
            }
            maxQueue.addLast(nums[j]);
            while (maxQueue.getFirst() - minQueue.getFirst() > limit) {
                if (maxQueue.getFirst() == nums[i]) maxQueue.removeFirst();
                if (minQueue.getFirst() == nums[i]) minQueue.removeFirst();
                i++;
            }
            res = Math.max(res, j - i + 1);
            j++;
        }
        return res;
    }
}

package company.uber.q1400;

import java.util.LinkedList;
import java.util.Queue;

public class Q1438 {
    public int longestSubarray(int[] nums, int limit) {
        int i = 0, j = 0, res = 0;
        LinkedList<Integer> maxQueue = new LinkedList<>();
        LinkedList<Integer> minQueue = new LinkedList<>();
        while (j < nums.length) {
            while (!maxQueue.isEmpty() && maxQueue.getLast() < nums[j]) {
                maxQueue.removeLast();
            }
            maxQueue.addLast(nums[j]);
            while (!minQueue.isEmpty() && minQueue.getLast() > nums[j]) {
                minQueue.removeLast();
            }
            minQueue.addLast(nums[j]);
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

package company.uber.q1400;

import java.util.LinkedList;
import java.util.Queue;

public class Q1438 {
    public int longestSubarray(int[] nums, int limit) {
        int i = 0, j = 0, res = 0;
        LinkedList<Integer> maxQueue = new LinkedList<>();
        LinkedList<Integer> minQueue = new LinkedList<>();
        while (j < nums.length) {
            while (!maxQueue.isEmpty() && nums[j] > maxQueue.getLast()) {
                maxQueue.removeLast();
            }
            maxQueue.addLast(nums[j]);
            while (!minQueue.isEmpty() && nums[j] < minQueue.getLast()) {
                minQueue.removeLast();
            }
            minQueue.addLast(nums[j]);
            while (maxQueue.getFirst() - minQueue.getFirst() > limit) {
                if (minQueue.getFirst() == nums[i]) minQueue.removeFirst();
                if (maxQueue.getFirst() == nums[i]) maxQueue.removeFirst();
                i++;
            }
            res = Math.max(res, j - i + 1);
            j++;
        }
        return res;
    }
}

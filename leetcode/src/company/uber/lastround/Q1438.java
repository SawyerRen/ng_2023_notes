package company.uber.lastround;

import java.util.LinkedList;

public class Q1438 {
    public int longestSubarray(int[] nums, int limit) {
        int i = 0, j = 0, res = 0;
        LinkedList<Integer> minQueue = new LinkedList<>();
        LinkedList<Integer> maxQueue = new LinkedList<>();
        while (j < nums.length) {
            while (!minQueue.isEmpty() && nums[j] < minQueue.peekLast()) {
                minQueue.removeLast();
            }
            minQueue.addLast(nums[j]);
            while (!maxQueue.isEmpty() && nums[j] > maxQueue.peekLast()) {
                maxQueue.removeLast();
            }
            maxQueue.addLast(nums[j]);
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

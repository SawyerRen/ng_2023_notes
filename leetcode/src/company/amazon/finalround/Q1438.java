package company.amazon.finalround;

import java.util.LinkedList;

public class Q1438 {
    public int longestSubarray(int[] nums, int limit) {
        LinkedList<Integer> maxQueue = new LinkedList<>();
        LinkedList<Integer> minQueue = new LinkedList<>();
        int i = 0, j = 0, res = 0;
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
                if (nums[i] == maxQueue.getFirst()) maxQueue.removeFirst();
                if (nums[i] == minQueue.getFirst()) minQueue.removeFirst();
                i++;
            }
            res = Math.max(res, j - i + 1);
            j++;
        }
        return res;
    }
}

package company.uber.q1400;

import java.util.Deque;
import java.util.LinkedList;
import java.util.TreeMap;
import java.util.TreeSet;

public class Q1438 {
    public int longestSubarray(int[] nums, int limit) {
        Deque<Integer> maxQueue = new LinkedList<>();
        Deque<Integer> minQueue = new LinkedList<>();
        int i = 0, j = 0, res = 0;
        while (j < nums.length) {
            while (!maxQueue.isEmpty() && nums[j] > maxQueue.peekLast()) {
                maxQueue.removeLast();
            }
            maxQueue.addLast(nums[j]);
            while (!minQueue.isEmpty() && nums[j] < minQueue.peekLast()) {
                minQueue.removeLast();
            }
            minQueue.addLast(nums[j]);
            while (maxQueue.peekFirst() - minQueue.peekFirst() > limit) {
                if (maxQueue.peekFirst() == nums[i]) maxQueue.removeFirst();
                if (minQueue.peekFirst() == nums[i]) minQueue.removeFirst();
                i++;
            }
            res = Math.max(res, j - i + 1);
            j++;
        }
        return res;
    }

    public int longestSubarray1(int[] nums, int limit) {
        int res = 0, i = 0, j = 0;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        while (j < nums.length) {
            map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);
            while (map.size() >= 2 && map.lastKey() - map.firstKey() > limit) {
                map.put(nums[i], map.get(nums[i]) - 1);
                if (map.get(nums[i]) == 0) map.remove(nums[i]);
                i++;
            }
            res = Math.max(res, j - i + 1);
            j++;
        }
        return res;
    }
}

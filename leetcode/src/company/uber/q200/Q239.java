package company.uber.q200;

import java.util.LinkedList;
import java.util.Queue;

public class Q239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            while (!queue.isEmpty() && queue.peekFirst() < i - k + 1) queue.removeFirst();
            while (!queue.isEmpty() && nums[queue.peekLast()] < nums[i]) queue.removeLast();
            queue.addLast(i);
            if (i - k + 1 >= 0) res[i - k + 1] = nums[queue.peekFirst()];
        }
        return res;
    }
}

package company.uber.all1;

import java.util.LinkedList;
import java.util.Queue;

public class Q239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            while (!queue.isEmpty() && queue.getFirst() < i - k + 1) {
                queue.removeFirst();
            }
            while (!queue.isEmpty() && nums[queue.getLast()] < nums[i]) {
                queue.removeLast();
            }
            queue.addLast(i);
            if (i - k + 1 >= 0) {
                res[i - k + 1] = nums[queue.getFirst()];
            }
        }
        return res;
    }
}

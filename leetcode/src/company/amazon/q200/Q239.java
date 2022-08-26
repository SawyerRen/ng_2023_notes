package company.amazon.q200;

import java.util.LinkedList;

public class Q239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n - k + 1];
        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            while (!queue.isEmpty() && queue.getFirst() < i - k + 1) {
                queue.removeFirst();
            }
            while (!queue.isEmpty() && nums[i] > nums[queue.getLast()]) {
                queue.removeLast();
            }
            queue.addLast(i);
            if (i - k + 1 >= 0) res[i - k + 1] = nums[queue.getFirst()];
        }
        return res;
    }
}

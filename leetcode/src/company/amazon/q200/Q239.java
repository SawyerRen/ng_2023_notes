package company.amazon.q200;

import java.util.LinkedList;

public class Q239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        LinkedList<Integer> list = new LinkedList<>();
        int[] res = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length; i++) {
            while (!list.isEmpty() && list.getFirst() < i - k + 1) {
                list.removeFirst();
            }
            while (!list.isEmpty() && nums[i] > nums[list.getLast()]) {
                list.removeLast();
            }
            list.addLast(i);
            if (i - k + 1 >= 0) {
                res[i - k + 1] = nums[list.getFirst()];
            }
        }
        return res;
    }
}

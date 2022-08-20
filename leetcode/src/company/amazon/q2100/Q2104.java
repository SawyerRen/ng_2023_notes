package company.amazon.q2100;

import java.util.Deque;
import java.util.LinkedList;

public class Q2104 {
    public long subArrayRanges(int[] nums) {
        long res = 0;
        Deque<Integer> stack = new LinkedList<>();
        stack.addLast(-1);
        for (int i = 0; i <= nums.length; i++) {
            while (stack.peekLast() != -1 && (i == nums.length || nums[i] >= nums[stack.peekLast()])) {
                Integer pop = stack.removeLast();
                int range = (pop - stack.peekLast()) * (i - pop);
                res += (long) range * nums[pop];
            }
            stack.addLast(i);
        }
        stack.clear();
        stack.addLast(-1);
        for (int i = 0; i <= nums.length; i++) {
            while (stack.peekLast() != -1 && (i == nums.length || nums[i] <= nums[stack.peekLast()])) {
                Integer pop = stack.removeLast();
                int range = (pop - stack.peekLast()) * (i - pop);
                res -= (long) range * nums[pop];
            }
            stack.addLast(i);
        }
        return res;
    }
}

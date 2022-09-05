package company.uber.q500;

import java.util.Stack;

public class Q581 {
    public int findUnsortedSubarray(int[] nums) {
        int left = nums.length, right = -1;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] > nums[i]) {
                left = Math.min(left, stack.pop());
            }
            stack.push(i);
        }
        stack.clear();
        for (int i = nums.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
                right = Math.max(right, stack.pop());
            }
            stack.push(i);
        }
        return left >= right ? 0 : right - left + 1;
    }
}

package company.uber.lastround;

import java.util.Stack;

public class Q581 {
    public int findUnsortedSubarray(int[] nums) {
        int left = nums.length, right = -1;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && nums[i] < nums[stack.peek()]) {
                left = Math.min(left, stack.pop());
            }
            stack.push(i);
        }
        stack.clear();
        for (int i = nums.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[i] > nums[stack.peek()]) {
                right = Math.max(right, stack.pop());
            }
            stack.push(i);
        }
        if (left >= right) return 0;
        return right - left + 1;
    }
}

package company.amazon.q0;

import java.util.Stack;

public class Q84 {
    public int largestRectangleArea(int[] heights) {
        int[] nums = new int[heights.length + 2];
        System.arraycopy(heights, 0, nums, 1, heights.length);
        Stack<Integer> stack = new Stack<>();
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && nums[i] < nums[stack.peek()]) {
                Integer index = stack.pop();
                int h = nums[index];
                int w = i - stack.peek() - 1;
                res = Math.max(res, h * w);
            }
            stack.push(i);
        }
        return res;
    }
}

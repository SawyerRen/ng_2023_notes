package company.amazon.q2100;

import java.util.Stack;

public class Q2104 {
    public long subArrayRanges(int[] nums) {
        long res = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i <= nums.length; i++) {
            while (stack.peek() != -1 && (i == nums.length || nums[i] >= nums[stack.peek()])) {
                int cur = stack.pop();
                int left = stack.peek();
                res += (long) (cur - left) * (i - cur) * nums[cur];
            }
            stack.push(i);
        }
        stack.clear();
        stack.push(-1);
        for (int i = 0; i <= nums.length; i++) {
            while (stack.peek() != -1 && (i == nums.length || nums[i] <= nums[stack.peek()])) {
                int cur = stack.pop();
                int left = stack.peek();
                res -= (long) (cur - left) * (i - cur) * nums[cur];
            }
            stack.push(i);
        }
        return res;
    }
}

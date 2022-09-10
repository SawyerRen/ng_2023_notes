package company.amazon.q2100;

import java.util.Stack;

public class Q2104 {
    public long subArrayRanges(int[] nums) {
        long res = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < nums.length + 1; i++) {
            while (stack.peek() != -1 && (i == nums.length || nums[i] > nums[stack.peek()])) {
                int cur = stack.pop();
                int left = stack.peek();
                int right = i;
                res += (long) nums[cur] * (right - cur) * (cur - left);
            }
            stack.push(i);
        }
        stack.clear();
        stack.push(-1);
        for (int i = 0; i < nums.length + 1; i++) {
            while (stack.peek() != -1 && (i == nums.length || nums[i] < nums[stack.peek()])) {
                int cur = stack.pop();
                int left = stack.peek();
                int right = i;
                res -= (long) nums[cur] * (right - cur) * (cur - left);
            }
            stack.push(i);
        }
        return res;
    }
}

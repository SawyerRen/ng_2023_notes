package company.bloomberg.vo;

import java.util.Stack;

public class Q84 {
    public int largestRectangleArea(int[] heights) {
        int[] arr = new int[heights.length + 2];
        System.arraycopy(heights, 0, arr, 1, heights.length);
        Stack<Integer> stack = new Stack<>();
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[i] < arr[stack.peek()]) {
                int h = arr[stack.pop()];
                int w = i - stack.peek() - 1;
                res = Math.max(res, h * w);
            }
            stack.push(i);
        }
        return res;
    }
}

package company.amazon.finalround;

import java.util.Stack;

public class Q907 {
    public int sumSubarrayMins(int[] arr) {
        long res = 0;
        int mod = 1000000007;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i <= arr.length; i++) {
            while (stack.peek() != -1 && (i == arr.length || arr[i] < arr[stack.peek()])) {
                int cur = stack.pop();
                int left = stack.peek();
                int right = i;
                long count = (cur - left) * (right - cur) % mod;
                res = (res + count * arr[cur]) % mod;
            }
            stack.push(i);
        }
        return (int) res;
    }
}

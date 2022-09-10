package company.amazon.q900;

import java.util.Stack;

public class Q907 {
    public int sumSubarrayMins(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        long res = 0;
        long mod = 1000000007;
        for (int i = 0; i <= arr.length; i++) {
            while (stack.peek() != -1 && (i == arr.length || arr[i] < arr[stack.peek()])) {
                int cur = stack.pop();
                long count = (cur - stack.peek()) * (i - cur) % mod;
                res = (res + count * arr[cur]) % mod;
            }
            stack.push(i);
        }
        return (int) res;
    }
}

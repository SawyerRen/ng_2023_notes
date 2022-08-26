package company.amazon.q900;

import java.util.Stack;

public class Q907 {
    public int sumSubarrayMins(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        long res = 0;
        long mod = (long)1e9 + 7;
        for (int i = 0; i <= arr.length; i++) {
            int curVal = i == arr.length ? 0 : arr[i];
            while (stack.peek() != -1 && curVal < arr[stack.peek()]) {
                int cur = stack.pop();
                long subArrayCount = (i - cur) * (cur - stack.peek()) % mod;
                res = (res + arr[cur] * subArrayCount) % mod;
            }
            stack.push(i);
        }
        return (int) res;
    }
}

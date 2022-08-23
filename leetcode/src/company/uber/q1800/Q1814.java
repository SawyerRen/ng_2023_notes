package company.uber.q1800;

import java.util.HashMap;
import java.util.Map;

public class Q1814 {
    public int countNicePairs(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            int rev = 0;
            int temp = num;
            while (temp != 0) {
                rev = rev * 10 + temp % 10;
                temp /= 10;
            }
            int diff = num - rev;
            map.put(diff, map.getOrDefault(diff, 0) + 1);
        }
        int mod = 1000000007;
        long res = 0;
        for (Integer count : map.values()) {
            res = (res + (long) count * (count - 1) / 2) % mod;
        }
        return (int) res;
    }
}

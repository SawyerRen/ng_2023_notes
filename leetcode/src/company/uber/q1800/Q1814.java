package company.uber.q1800;

import java.util.HashMap;
import java.util.Map;

public class Q1814 {
    public int countNicePairs(int[] nums) {
        Map<Long, Integer> map = new HashMap<>();
        int res = 0;
        int mod = 1000000007;
        for (int num : nums) {
            int temp = num;
            long rev = 0;
            while (temp != 0) {
                rev = rev * 10 + temp % 10;
                temp /= 10;
            }
            long diff = num - rev;
            res = (res + map.getOrDefault(diff, 0)) % mod;
            map.put(diff, map.getOrDefault(diff, 0) + 1);
        }
        return res;
    }
}

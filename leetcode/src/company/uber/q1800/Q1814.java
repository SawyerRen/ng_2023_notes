package company.uber.q1800;

import java.util.HashMap;
import java.util.Map;

public class Q1814 {
    public int countNicePairs(int[] nums) {
        int mod = 1000000007;
        long res = 0;
        Map<Long, Long> map = new HashMap<>();
        for (int num : nums) {
            long rev = 0;
            int temp = num;
            while (temp != 0) {
                rev = rev * 10 + temp % 10;
                temp /= 10;
            }
            long diff = num - rev;
            if (map.containsKey(diff)) {
                res = (res + map.get(diff)) % mod;
            }
            map.put(diff, map.getOrDefault(diff, 0L) + 1);
        }
        return (int) res;
    }
}

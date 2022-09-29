package company.uber.goodluck;

import java.util.HashMap;
import java.util.Map;

public class Q1814 {
    public int countNicePairs(int[] nums) {
        Map<Long, Integer> map = new HashMap<>();
        long res = 0;
        for (int num : nums) {
            int temp = num;
            long rev = 0;
            while (temp != 0) {
                rev = rev * 10 + temp % 10;
                temp /= 10;
            }
            long diff = num - rev;
            res += map.getOrDefault(diff, 0);
            map.put(diff, map.getOrDefault(diff, 0) + 1);
        }
        return (int) res % 1000000007;
    }
}

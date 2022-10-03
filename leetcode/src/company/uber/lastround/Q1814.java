package company.uber.lastround;

import java.util.HashMap;
import java.util.Map;

public class Q1814 {
    public int countNicePairs(int[] nums) {
        Map<Long, Long> map = new HashMap<>();
        int res = 0;
        for (int num : nums) {
            long rev = 0;
            int temp = num;
            while (temp != 0) {
                rev = rev * 10 + temp % 10;
                temp /= 10;
            }
            long diff = num - rev;
            res = (int) ((res + map.getOrDefault(diff, 0L)) % 1000000007);
            map.put(diff, map.getOrDefault(diff, 0L) + 1);
        }
        return res;
    }
}

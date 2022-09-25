package company.uber.all1;

import java.util.HashMap;
import java.util.Map;

public class Q1814 {
    public int countNicePairs(int[] nums) {
        long res = 0;
        Map<Long, Integer> map = new HashMap<>();
        for (int num : nums) {
            int temp = num;
            long rev = 0;
            while (temp != 0) {
                rev = rev * 10 + temp % 10;
                temp /= 10;
            }
            long n = num - rev;
            res = (res + map.getOrDefault(n, 0)) % 1000000007;
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        return (int) res;
    }
}

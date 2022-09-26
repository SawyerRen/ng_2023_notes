package company.uber.all1;

import java.util.HashMap;
import java.util.Map;

public class Q2023 {
    public int numOfPairs(String[] nums, String target) {
        int res = 0;
        Map<String, Integer> map = new HashMap<>();
        for (String num : nums) {
            if (target.startsWith(num)) {
                String sub = target.substring(num.length());
                res += map.getOrDefault(sub, 0);
            }
            if (target.endsWith(num)) {
                String sub = target.substring(0, target.length() - num.length());
                res += map.getOrDefault(sub, 0);
            }
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        return res;
    }
}
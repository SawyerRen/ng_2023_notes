package company.bloomberg.goodluck;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q697 {
    public int findShortestSubArray(int[] nums) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int maxFreq = 0;
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            map.putIfAbsent(nums[i], new ArrayList<>());
            map.get(nums[i]).add(i);
            if (map.get(nums[i]).size() > maxFreq) {
                maxFreq = map.get(nums[i]).size();
                res = map.get(nums[i]).get(maxFreq - 1) - map.get(nums[i]).get(0) + 1;
            } else if (maxFreq == map.get(nums[i]).size()) {
                res = Math.min(res, map.get(nums[i]).get(maxFreq - 1) - map.get(nums[i]).get(0) + 1);
            }
        }
        return res;
    }
}

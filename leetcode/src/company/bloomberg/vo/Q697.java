package company.bloomberg.vo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q697 {
    public int findShortestSubArray(int[] nums) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int maxFreq = 0, res = 0;
        for (int i = 0; i < nums.length; i++) {
            List<Integer> list = map.getOrDefault(nums[i], new ArrayList<>());
            list.add(i);
            map.put(nums[i], list);
            if (list.size() > maxFreq) {
                maxFreq = list.size();
                res = i - list.get(0) + 1;
            } else if (list.size() == maxFreq) {
                res = Math.min(res, i - list.get(0) + 1);
            }
        }
        return res;
    }
}

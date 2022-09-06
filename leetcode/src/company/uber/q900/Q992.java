package company.uber.q900;

import java.util.HashMap;
import java.util.Map;

public class Q992 {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return atMostK(nums, k) - atMostK(nums, k - 1);
    }

    private int atMostK(int[] nums, int k) {
        int i = 0, j = 0, res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        while (j < nums.length) {
            map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);
            while (map.size() > k) {
                map.put(nums[i], map.get(nums[i]) - 1);
                if (map.get(nums[i]) == 0) map.remove(nums[i]);
                i++;
            }
            res += j - i + 1;
            j++;
        }
        return res;
    }
}

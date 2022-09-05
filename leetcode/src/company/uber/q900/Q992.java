package company.uber.q900;

import java.util.HashMap;
import java.util.Map;

public class Q992 {
    public int subarraysWithKDistinct(int[] nums, int k) {
        Map<Integer, Integer> countAtMostK = new HashMap<>();
        Map<Integer, Integer> countAtMostKMinus1 = new HashMap<>();
        int i1 = 0, i2 = 0, j = 0;
        int res = 0;
        while (j < nums.length) {
            countAtMostK.put(nums[j], countAtMostK.getOrDefault(nums[j], 0) + 1);
            countAtMostKMinus1.put(nums[j], countAtMostKMinus1.getOrDefault(nums[j], 0) + 1);
            while (countAtMostK.size() > k) {
                countAtMostK.put(nums[i1], countAtMostK.get(nums[i1]) - 1);
                if (countAtMostK.get(nums[i1]) == 0) countAtMostK.remove(nums[i1]);
                i1++;
            }
            while (countAtMostKMinus1.size() >= k) {
                countAtMostKMinus1.put(nums[i2], countAtMostKMinus1.get(nums[i2]) - 1);
                if (countAtMostKMinus1.get(nums[i2]) == 0) countAtMostKMinus1.remove(nums[i2]);
                i2++;
            }
            res += i2 - i1;
            j++;
        }
        return res;
    }
}

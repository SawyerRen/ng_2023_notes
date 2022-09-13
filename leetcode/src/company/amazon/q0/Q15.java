package company.amazon.q0;

import java.lang.reflect.Array;
import java.util.*;

public class Q15 {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0) break;
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            helper(res, nums, i);
        }
        return res;
    }

    private void helper(List<List<Integer>> res, int[] nums, int i) {
        int target = -nums[i];
        Map<Integer, Integer> map = new HashMap<>();
        for (int j = i + 1; j < nums.length; j++) {
            if (map.containsKey(target - nums[j])) {
                res.add(Arrays.asList(nums[i], nums[j], target - nums[j]));
                while (j + 1 < nums.length && nums[j] == nums[j + 1]) j++;
            }
            map.put(nums[j], j);
        }
    }

    public List<List<Integer>> threeSum1(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0) break;
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;
                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return res;
    }
}

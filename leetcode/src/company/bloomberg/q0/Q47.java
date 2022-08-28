package company.bloomberg.q0;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Q47 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        helper(res, new ArrayList<Integer>(), nums, new boolean[nums.length]);
        return res;
    }

    private void helper(List<List<Integer>> res, ArrayList<Integer> list, int[] nums, boolean[] visited) {
        if (list.size() == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) continue;
            if (i > 0 && nums[i] == nums[i - 1] && visited[i - 1]) continue;
            list.add(nums[i]);
            visited[i] = true;
            helper(res, list, nums, visited);
            list.remove(list.size() - 1);
            visited[i] = false;
        }
    }
}

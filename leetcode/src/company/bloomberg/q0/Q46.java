package company.bloomberg.q0;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Q46 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(res, new ArrayList<Integer>(), nums, new HashSet<Integer>());
        return res;
    }

    private void backtrack(List<List<Integer>> res, ArrayList<Integer> list, int[] nums, HashSet<Integer> visited) {
        if (list.size() == nums.length) {
            res.add(new ArrayList<>(list));
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited.contains(nums[i])) continue;
            list.add(nums[i]);
            visited.add(nums[i]);
            backtrack(res, list, nums, visited);
            list.remove(list.size() - 1);
            visited.remove(nums[i]);
        }
    }
}

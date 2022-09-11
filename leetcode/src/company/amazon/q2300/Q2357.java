package company.amazon.q2300;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Q2357 {
    public int minimumOperations(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (num > 0) set.add(num);
        }
        return set.size();
    }
}

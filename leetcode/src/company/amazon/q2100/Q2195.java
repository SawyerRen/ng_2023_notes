package company.amazon.q2100;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Q2195 {
    public long minimalKSum(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 1; list.size() < k; i++) {
            if (!set.contains(i)) list.add(i);
        }
        long sum = 0;
        for (Integer v : list) {
            sum += v;
        }
        return sum;
    }
}

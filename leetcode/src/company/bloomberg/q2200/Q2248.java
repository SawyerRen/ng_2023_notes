package company.bloomberg.q2200;

import java.util.*;

public class Q2248 {
    public List<Integer> intersection(int[][] nums) {
        int n = nums.length;
        int[] count = new int[1001];
        for (int[] num : nums) {
            for (int i : num) {
                count[i]++;
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < count.length; i++) {
            if (count[i] == n) res.add(i);
        }
        return res;
    }
}

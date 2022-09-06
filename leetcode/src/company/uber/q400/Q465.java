package company.uber.q400;

import java.util.HashMap;
import java.util.Map;

public class Q465 {
    public int minTransfers(int[][] transactions) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] t : transactions) {
            map.put(t[0], map.getOrDefault(t[0], 0) - t[2]);
            map.put(t[1], map.getOrDefault(t[1], 0) + t[2]);
        }
        int[] debts = new int[map.size()];
        int i = 0;
        for (Integer value : map.values()) {
            debts[i++] = value;
        }
        return helper(debts, 0);
    }

    private int helper(int[] debts, int index) {
        if (index == debts.length) return 0;
        if (debts[index] == 0) return helper(debts, index + 1);
        int res = Integer.MAX_VALUE;
        for (int next = index + 1; next < debts.length; next++) {
            if (debts[index] * debts[next] < 0) {
                debts[next] += debts[index];
                res = Math.min(res, helper(debts, index + 1) + 1);
                debts[next] -= debts[index];
            }
        }
        return res;
    }
}

package company.uber.lastround;

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

    private int helper(int[] debts, int i) {
        if (i == debts.length) return 0;
        if (debts[i] == 0) return helper(debts, i + 1);
        int res = Integer.MAX_VALUE;
        for (int j = i + 1; j < debts.length; j++) {
            if (debts[i] * debts[j] < 0) {
                debts[j] += debts[i];
                res = Math.min(res, helper(debts, i + 1) + 1);
                debts[j] -= debts[i];
            }
        }
        return res;
    }
}

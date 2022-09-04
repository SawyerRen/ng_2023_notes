package company.uber.q400;

import java.util.HashMap;
import java.util.Map;

public class Q465 {
    public int minTransfers(int[][] transactions) {
        int[] debts = buildDebts(transactions);
        return helper(debts, 0);
    }

    private int helper(int[] debts, int index) {
        if (index == debts.length) return 0;
        if (debts[index] == 0) return helper(debts, index + 1);
        int res = Integer.MAX_VALUE;
        for (int i = index + 1; i < debts.length; i++) {
            if (debts[index] * debts[i] < 0) {
                debts[i] += debts[index];
                res = Math.min(res, helper(debts, index + 1) + 1);
                debts[i] -= debts[index];
            }
        }
        return res;
    }

    private int[] buildDebts(int[][] transactions) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] t : transactions) {
            map.put(t[0], map.getOrDefault(t[0], 0) - t[2]);
            map.put(t[1], map.getOrDefault(t[1], 0) + t[2]);
        }
        int[] debts = new int[map.size()];
        int index = 0;
        for (Integer value : map.values()) {
            debts[index++] = value;
        }
        return debts;
    }
}

package company.uber.q400;

import java.util.HashMap;
import java.util.Map;

public class Q465 {
    public int minTransfers(int[][] transactions) {
        int[] debts = getDebts(transactions);
        return getMin(debts, 0);
    }

    private int getMin(int[] debts, int i) {
        if (i == debts.length) return 0;
        if (debts[i] == 0) return getMin(debts, i + 1);
        int res = Integer.MAX_VALUE;
        for (int j = i + 1; j < debts.length; j++) {
            if (debts[i] * debts[j] < 0) {
                debts[j] += debts[i];
                res = Math.min(res, getMin(debts, i + 1) + 1);
                debts[j] -= debts[i];
            }
        }
        return res;
    }

    private int[] getDebts(int[][] transactions) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] transaction : transactions) {
            map.put(transaction[0], map.getOrDefault(transaction[0], 0) - transaction[2]);
            map.put(transaction[1], map.getOrDefault(transaction[1], 0) + transaction[2]);
        }
        int[] debts = new int[map.size()];
        int index = 0;
        for (Integer value : map.values()) {
            debts[index++] = value;
        }
        return debts;
    }
}

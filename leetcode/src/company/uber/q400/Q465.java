package company.uber.q400;

import java.util.HashMap;
import java.util.Map;

public class Q465 {
    public int minTransfers(int[][] transactions) {
        int[] debts = buildDebts(transactions);
        return findMinTransfers(debts, 0);
    }

    private int findMinTransfers(int[] debts, int curIndex) {
        if (curIndex == debts.length) return 0;
        if (debts[curIndex] == 0) return findMinTransfers(debts, curIndex + 1);
        int res = Integer.MAX_VALUE;
        for (int i = curIndex + 1; i < debts.length; i++) {
            if (debts[curIndex] * debts[i] < 0) {
                debts[i] += debts[curIndex];
                res = Math.min(res, findMinTransfers(debts, curIndex + 1) + 1);
                debts[i] -= debts[curIndex];
            }
        }
        return res;
    }

    private int[] buildDebts(int[][] transactions) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] transaction : transactions) {
            map.put(transaction[0], map.getOrDefault(transaction[0], 0) - transaction[2]);
            map.put(transaction[1], map.getOrDefault(transaction[1], 0) + transaction[2]);
        }
        int[] debts = new int[map.size()];
        int i = 0;
        for (Integer value : map.values()) {
            debts[i++] = value;
        }
        return debts;
    }
}

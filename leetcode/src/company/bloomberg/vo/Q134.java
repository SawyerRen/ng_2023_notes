package company.bloomberg.vo;

public class Q134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0, totalCost = 0;
        for (int i = 0; i < gas.length; i++) {
            totalCost += cost[i];
            totalGas += gas[i];
        }
        if (totalCost > totalGas) return -1;
        int curGas = 0, index = 0;
        for (int i = 0; i < gas.length; i++) {
            curGas += gas[i] - cost[i];
            if (curGas < 0) {
                index = i + 1;
                curGas = 0;
            }
        }
        return index;
    }
}

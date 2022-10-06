package company.bloomberg.all.q100;

public class Q134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0, totalCost = 0;
        for (int i = 0; i < gas.length; i++) {
            totalCost += cost[i];
            totalGas += gas[i];
        }
        if (totalCost > totalGas) return -1;
        int start = 0;
        int remainGas = 0;
        for (int i = 0; i < gas.length; i++) {
            remainGas += gas[i] - cost[i];
            if (remainGas < 0) {
                start = i + 1;
                remainGas = 0;
            }
        }
        return start;
    }
}

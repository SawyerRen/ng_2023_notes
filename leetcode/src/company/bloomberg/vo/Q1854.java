package company.bloomberg.vo;

public class Q1854 {
    public int maximumPopulation(int[][] logs) {
        int[] arr = new int[2051];
        for (int[] log : logs) {
            arr[log[0]]++;
            arr[log[1]]--;
        }
        int maxCount = 0, count = 0, res = -1;
        for (int i = 1950; i < 2051; i++) {
            count += arr[i];
            if (count > maxCount) {
                maxCount = count;
                res = i;
            }
        }
        return res;
    }
}

package company.bloomberg.all;

public class Q1854 {
    public int maximumPopulation(int[][] logs) {
        int[] arr = new int[2051];
        for (int[] log : logs) {
            arr[log[0]]++;
            arr[log[1]]--;
        }
        int cur = 0;
        int max = 0;
        int maxYear = 1949;
        for (int i = 1950; i < 2051; i++) {
            cur += arr[i];
            if (cur > max) {
                max = cur;
                maxYear = i;
            }
        }
        return maxYear;
    }
}

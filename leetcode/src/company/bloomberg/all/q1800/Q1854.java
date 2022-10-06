package company.bloomberg.all.q1800;

public class Q1854 {
    public int maximumPopulation(int[][] logs) {
        int[] years = new int[2051];
        for (int[] log : logs) {
            years[log[0]]++;
            years[log[1]]--;
        }
        int max = 0, maxYear = 0;
        int sum = 0;
        for (int i = 1950; i < 2051; i++) {
            sum += years[i];
            if (sum > max) {
                max = sum;
                maxYear = i;
            }
        }
        return maxYear;
    }
}

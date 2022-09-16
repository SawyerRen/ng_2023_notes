package company.amazon.finalround;

public class Q688 {
    private int[][] dirs = new int[][]{{-2, -1}, {-1, -2}, {1, -2}, {2, -1}, {2, 1}, {1, 2}, {-1, 2}, {-2, 1}};

    public double knightProbability(int n, int k, int row, int column) {
        double[][][] memo = new double[n + 1][n + 1][k + 1];
        return helper(memo, n, k, row, column);
    }

    private double helper(double[][][] memo, int n, int k, int i, int j) {
        if (i < 0 || i >= n || j < 0 || j >= n) return 0;
        if (k == 0) return 1;
        if (memo[i][j][k] != 0) return memo[i][j][k];
        double res = 0;
        for (int[] dir : dirs) {
            res += 0.125 * (helper(memo, n, k - 1, i + dir[0], j + dir[1]));
        }
        memo[i][j][k] = res;
        return res;
    }
}

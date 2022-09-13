package company.amazon.q600;

public class Q688 {
    private int[][] dirs = new int[][]{{-2, -1}, {-1, -2}, {1, -2}, {2, -1}, {2, 1}, {1, 2}, {-1, 2}, {-2, 1}};

    public double knightProbability(int n, int k, int row, int column) {
        double[][][] memo = new double[n][n][k + 1];
        return helper(memo, n, k, row, column);
    }

    private double helper(double[][][] memo, int n, int k, int i, int j) {
        if (k == 0) return 1;
        if (memo[i][j][k] != 0) return memo[i][j][k];
        double res = 0;
        for (int[] dir : dirs) {
            int x = i + dir[0], y = j + dir[1];
            if (x < 0 || x >= n || y < 0 || y >= n) continue;
            res += 0.125 * helper(memo, n, k - 1, x, y);
        }
        memo[i][j][k] = res;
        return res;
    }
}

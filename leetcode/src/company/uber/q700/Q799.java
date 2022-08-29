package company.uber.q700;

public class Q799 {
    public double champagneTower(int poured, int query_row, int query_glass) {
        double[][] tower = new double[102][102];
        tower[0][0] = (double) poured;
        for (int i = 0; i < query_row + 1; i++) {
            for (int j = 0; j < i + 1; j++) {
                double split = (tower[i][j] - 1.0) / 2.0;
                if (split > 0) {
                    tower[i + 1][j] += split;
                    tower[i + 1][j + 1] += split;
                }
            }
        }
        return Math.min(1, tower[query_row][query_glass]);
    }
}

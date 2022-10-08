package company.bloomberg.vo;

public class Q566 {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int m = mat.length, n = mat[0].length;
        if (m * n != r * c) return mat;
        int[][] res = new int[r][c];
        int count = 0;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                res[count / c][count % c] = mat[i][j];
                count++;
            }
        }
        return res;
    }
}

package company.uber.all1;

public class Q48 {
    public void rotate(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < i; j++) {
                int t = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = t;
            }
        }
        for (int[] row : matrix) {
            int i = 0, j = row.length - 1;
            while (i < j) {
                int t = row[i];
                row[i] = row[j];
                row[j] = t;
                i++;
                j--;
            }
        }
    }
}

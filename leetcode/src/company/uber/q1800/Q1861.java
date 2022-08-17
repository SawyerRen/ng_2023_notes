package company.uber.q1800;

public class Q1861 {
    public char[][] rotateTheBox(char[][] box) {
        int m = box.length, n = box[0].length;
        char[][] res = new char[n][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res[j][m - i - 1] = box[i][j];
            }
        }
        for (int col = 0; col < m; col++) {
            int empty = n - 1;
            for (int row = n - 1; row >= 0; row--) {
                if (res[row][col] == '*') {
                    empty = row - 1;
                } else if (res[row][col] == '#') {
                    res[row][col] = '.';
                    res[empty][col] = '#';
                    empty--;
                }
            }
        }
        return res;
    }
}

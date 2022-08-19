package company.uber.q1800;

public class Q1861 {
    public char[][] rotateTheBox(char[][] box) {
        int m = box.length, n = box[0].length;
        char[][] res = new char[n][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res[j][m - 1 - i] = box[i][j];
            }
        }
        for (int col = 0; col < m; col++) {
            int stoneRow = n - 1, row = n - 1;
            while (row >= 0) {
                if (res[row][col] == '*') {
                    stoneRow = row - 1;
                } else if (res[row][col] == '#') {
                    res[row][col] = '.';
                    res[stoneRow--][col] = '#';
                }
                row--;
            }
        }
        return res;
    }
}

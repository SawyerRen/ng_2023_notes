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
            int row = n - 1;
            int stone = n - 1;
            while (row >= 0) {
                if (res[row][col] == '#') {
                    res[row][col] = '.';
                    res[stone--][col] = '#';
                } else if (res[row][col] == '*') {
                    stone = row - 1;
                }
                row--;
            }
        }
        return res;
    }
}

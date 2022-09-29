package company.uber.goodluck;

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
            int row = n - 1;
            for (int i = n - 1; i >= 0; i--) {
                if (res[i][col] == '#') {
                    res[i][col] = '.';
                    res[row--][col] = '#';
                } else if (res[i][col] == '*') {
                    row = i - 1;
                }
            }
        }
        return res;
    }
}

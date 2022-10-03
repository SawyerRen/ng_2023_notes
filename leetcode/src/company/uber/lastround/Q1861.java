package company.uber.lastround;

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
            int index = n - 1;
            for (int row = n - 1; row >= 0; row--) {
                if (res[row][col] == '#') {
                    res[row][col] = '.';
                    res[index--][col] = '#';
                } else if (res[row][col] == '*') {
                    index = row - 1;
                }
            }
        }
        return res;
    }
}

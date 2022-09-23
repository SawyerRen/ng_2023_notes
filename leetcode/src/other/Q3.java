package other;

public class Q3 {
    int solution(int[][] matrix) {
        int n = matrix.length;
        int count0 = 0, count1 = 0, count2 = 0;
        int remain0 = 0, remain1 = 0, remain2 = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if ((i < n / 2 && (i == j || i == n - 1 - j))
                        || (i >= n / 2 && j == n / 2)) {
                    if (matrix[i][j] == 0) count0++;
                    else if (matrix[i][j] == 1) count1++;
                    else count2++;
                } else {
                    if (matrix[i][j] == 0) remain0++;
                    else if (matrix[i][j] == 1) remain1++;
                    else remain2++;
                }
            }
        }
        int yTotal = count0 + count1 + count2;
        int res = yTotal - count0 + remain0;
        res = Math.min(yTotal - count1 + remain1, res);
        res = Math.min(yTotal - count2 + remain2, res);
        return res;
    }
}

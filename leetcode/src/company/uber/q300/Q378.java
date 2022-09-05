package company.uber.q300;

import java.util.PriorityQueue;

public class Q378 {
    public int kthSmallest(int[][] matrix, int k) {
        int m = matrix.length, n = matrix[0].length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        for (int i = 0; i < m; i++) {
            pq.add(new int[]{i, 0, matrix[i][0]});
        }
        int res = 0;
        for (int i = 0; i < k; i++) {
            int[] poll = pq.poll();
            int row = poll[0], col = poll[1];
            res = poll[2];
            if (col + 1 < n) pq.add(new int[]{row, col + 1, matrix[row][col + 1]});
        }
        return res;
    }

    public int kthSmallest1(int[][] matrix, int k) {
        int m = matrix.length, n = matrix[0].length;
        int left = matrix[0][0], right = matrix[m - 1][n - 1];
        while (left < right) {
            int mid = left + (right - left) / 2;
            int count = getCount(matrix, mid);
            if (count >= k) right = mid;
            else left = mid + 1;
        }
        return left;
    }

    private int getCount(int[][] matrix, int mid) {
        int i = matrix.length - 1, j = 0;
        int count = 0;
        while (i >= 0 && j < matrix[0].length) {
            if (matrix[i][j] <= mid) {
                count += i + 1;
                j++;
            } else {
                i--;
            }
        }
        return count;
    }
}

package company.uber.all1;

import java.util.PriorityQueue;

public class Q378 {
    public int kthSmallest(int[][] matrix, int k) {
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
        int m = matrix.length, n = matrix[0].length;
        int i = m - 1, j = 0, count = 0;
        while (i >= 0 && j < n) {
            if (matrix[i][j] <= mid) {
                count += i + 1;
                j++;
            } else {
                i--;
            }
        }
        return count;
    }

    public int kthSmallest1(int[][] matrix, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> matrix[a[0]][a[1]] - matrix[b[0]][b[1]]);
        int m = matrix.length, n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            pq.add(new int[]{i, 0});
        }
        int res = 0;
        for (int i = 0; i < k; i++) {
            int[] poll = pq.poll();
            res = matrix[poll[0]][poll[1]];
            if (poll[1] + 1 < n) {
                pq.add(new int[]{poll[0], poll[1] + 1});
            }
        }
        return res;
    }
}

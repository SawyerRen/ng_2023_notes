package company.amazon.q300;

import java.util.PriorityQueue;

public class Q378 {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        int m = matrix.length, n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            pq.add(new int[]{i, 0, matrix[i][0]});
        }
        int res = 0;
        for (int i = 0; i < k; i++) {
            int[] poll = pq.poll();
            res = poll[2];
            int x = poll[0], y = poll[1];
            if (y + 1 < n) {
                pq.add(new int[]{x, y + 1, matrix[x][y + 1]});
            }
        }
        return res;
    }
}

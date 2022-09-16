package company.amazon.finalround;

import java.util.PriorityQueue;

public class Q378 {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> matrix[a[0]][a[1]] - matrix[b[0]][b[1]]);
        int m = matrix.length, n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            pq.add(new int[]{i, 0});
        }
        int res = 0;
        for (int i = 0; i < k; i++) {
            int[] poll = pq.poll();
            res = matrix[poll[0]][poll[1]];
            if (poll[1] + 1 < n) pq.add(new int[]{poll[0], poll[1] + 1});
        }
        return res;
    }
}

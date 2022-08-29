package company.uber.q1800;

import java.util.*;

public class Q1878 {
    public int[] getBiggestThree(int[][] grid) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        int m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                pq.add(grid[i][j]);
                for (int k = 1; k <= Math.min(m / 2, n / 2); k++) {
                    if (i - k >= 0 && i + k < m && j - k >= 0 && j + k < n) {
                        int sum = grid[i][j + k] + grid[i][j - k] + grid[i + k][j] + grid[i - k][j];
                        for (int l = 1; l < k; l++) {
                            sum += grid[i - l][j - k + l] + grid[i + l][j - k + l];
                            sum += grid[i - l][j + k - l] + grid[i + l][j + k - l];
                        }
                        pq.add(sum);
                    }
                }
            }
        }
        Set<Integer> set = new HashSet<>();
        while (!pq.isEmpty() && set.size() < 3) {
            set.add(pq.poll());
        }
        List<Integer> list = new ArrayList<>(set);
        list.sort(Comparator.reverseOrder());
        int[] res = new int[list.size()];
        int i = 0;
        for (Integer v : list) {
            res[i++] = v;
        }
        return res;
    }
}

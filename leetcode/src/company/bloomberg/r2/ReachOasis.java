package company.bloomberg.r2;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class ReachOasis {
    boolean solution(char[][] matrix, int gas) {
        int m = matrix.length, n = matrix[0].length;
        int[] start = null, end = null;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 'o') {
                    end = new int[]{i, j};
                } else if (matrix[i][j] == 'r') {
                    start = new int[]{i, j};
                }
            }
        }
        int dist = Math.abs(start[0] - end[0]) + Math.abs(end[1] - start[1]);
        return gas >= dist;
    }

    boolean solutionWithRefill(char[][] matrix, int gas) {
        int m = matrix.length, n = matrix[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int[] start = null, end = null;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 'o') {
                    end = new int[]{i, j};
                } else if (matrix[i][j] == 'r') {
                    start = new int[]{i, j};
                } else if (Character.isDigit(matrix[i][j])) {
                    queue.add(new int[]{i, j});
                }
            }
        }
        int dist = Math.abs(start[0] - end[0]) + Math.abs(end[1] - start[1]);
        if (dist <= gas) return true;
        for (int[] arr : queue) {
            int dist1 = Math.abs(start[0] - arr[0]) + Math.abs(arr[1] - start[1]);
            if (dist1 > gas) continue;
            int cur = gas - dist1 + (matrix[arr[0]][arr[1]] - '0');
            int dist2 = Math.abs(arr[0] - end[0]) + Math.abs(end[1] - arr[1]);
            if (dist2 <= cur) return true;
        }
        return false;
    }

    boolean solutionWithObstacles(char[][] matrix, int gas) {
        int m = matrix.length, n = matrix[0].length;
        int[] start = null, end = null;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 'o') {
                    end = new int[]{i, j};
                } else if (matrix[i][j] == 'r') {
                    start = new int[]{i, j};
                }
            }
        }
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{start[0], start[1], gas, 1});
        Set<String> visited = new HashSet<>();
        visited.add("");
        int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int i = poll[0], j = poll[1], curGas = poll[2], refill = poll[3];
            if (i == end[0] && j == end[1]) return true;
            if (curGas == 0) continue;
            for (int[] dir : dirs) {
                int x = i + dir[0], y = j + dir[1];
                if (x < 0 || x >= m || y < 0 || y >= n || matrix[x][y] == '!') continue;
                int nextGas = curGas - 1;
                queue.add(new int[]{x, y, nextGas, refill});
                if (Character.isDigit(matrix[x][y]) && refill == 1) {
                    queue.add(new int[]{x, y, nextGas + matrix[x][y] - '0', 0});
                }
            }
        }
        return false;
    }
}

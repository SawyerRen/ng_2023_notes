package company.bloomberg.mj.nontag2;

import java.util.LinkedList;
import java.util.Queue;

public class Q6 {
    boolean solution(int[][] matrix, int gas) {
        int m = matrix.length, n = matrix[0].length;
        int[] start = null, end = null;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 'r') {
                    start = new int[]{i, j};
                } else if (matrix[i][j] == 'o') {
                    end = new int[]{i, j};
                }
            }
        }
        int d = Math.abs(start[0] - end[0]) + Math.abs(start[1] - end[1]);
        return d <= gas;
    }

    boolean solution2(int[][] matrix, int gas) {
        int m = matrix.length, n = matrix[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int[] start = null, end = null;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 'r') {
                    start = new int[]{i, j};
                } else if (matrix[i][j] == 'o') {
                    end = new int[]{i, j};
                } else if (Character.isDigit(matrix[i][j])) {
                    queue.add(new int[]{i, j});
                }
            }
        }
        int d = Math.abs(start[0] - end[0]) + Math.abs(start[1] - end[1]);
        if (d <= gas) return true;
        for (int[] station : queue) {
            int d1 = Math.abs(start[0] - station[0]) + Math.abs(start[1] - station[1]);
            if (d1 > gas) continue;
            int d2 = Math.abs(end[0] - station[0]) + Math.abs(end[1] - station[1]);
            int curGas = gas + matrix[station[0]][station[1]] - '0';
            if (curGas >= d2) return true;
        }
        return false;
    }

    boolean solution3(int[][] matrix, int gas) {
        int m = matrix.length, n = matrix[0].length;
        int[] start = null, end = null;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 'r') {
                    start = new int[]{i, j};
                } else if (matrix[i][j] == 'o') {
                    end = new int[]{i, j};
                }
            }
        }
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{start[0], start[1], gas, 1});
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int i = poll[0], j = poll[1], curGas = poll[2], refill = poll[3];
            if (i == end[0] && j == end[1]) return true;
            if (curGas == 0) continue;

        }
        return false;
    }
}

package company.bloomberg.mj.nontag;

import javafx.util.Pair;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class ReachOasis {
    boolean solution2(char[][] matrix, int gas) {
        int[] start = null;
        int[] end = null;
        int m = matrix.length, n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 'c') {
                    start = new int[]{i, j};
                } else if (matrix[i][j] == 'o') {
                    end = new int[]{i, j};
                }
            }
        }
        Queue<int[]> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.add(new int[]{start[0], start[1], gas, 1});
        visited.add(start[0] + "," + start[1] + "," + gas + ",1");
        int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int i = poll[0], j = poll[1], curGas = poll[2], refill = poll[3];
            if (i == end[0] && j == end[1]) return true;
            if (curGas == 0) continue;
            for (int[] dir : dirs) {
                int x = i + dir[0], y = j + dir[1];
                if (x < 0 || x >= m || y < 0 || y >= n) continue;
                int nextGas = curGas - 1;
                if (Character.isDigit(matrix[x][y]) && refill == 1) {
                    nextGas += matrix[x][y] - '0';
                }
                if (visited.contains(x + "," + y + "," + nextGas + ",0")) continue;
                queue.add(new int[]{x, y, nextGas, 0});
            }
        }
        return false;
    }

    boolean solution(char[][] matrix, int gas) {
        int[] start = null;
        Queue<int[]> queue = new LinkedList<>();
        int[] end = null;
        int m = matrix.length, n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 'c') {
                    start = new int[]{i, j};
                } else if (matrix[i][j] == 'o') {
                    end = new int[]{i, j};
                } else if (matrix[i][j] != '.') {
                    queue.add(new int[]{i, j});
                }
            }
        }
        if (Math.abs(end[0] - start[0]) + Math.abs(end[1] - start[1]) <= gas) return true;
        for (int[] index : queue) {
            int dist1 = Math.abs(start[0] - index[0]) + Math.abs(start[1] - index[1]);
            if (gas < dist1) continue;
            int cur = gas - dist1 + (matrix[index[0]][index[1]] - '0');
            int dist2 = Math.abs(end[0] - index[0]) + Math.abs(end[1] - index[1]);
            if (dist2 <= cur) return true;
        }
        return false;
    }
}

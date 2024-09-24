package company.bloomberg.mj.nontag;

import javafx.util.Pair;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
有一个matrix，想象这个matrix是一个沙漠，中间有一个坐标是绿洲，有几个坐标是加油站
你从起点出发，每走一个要一个油，中间可以加一次油，问能不能到达绿洲
起点用'c'表示，绿洲用'o'表示，加油站用数字表示，数字是加油站有的油的数量，比如'1'表示可以加一个油
*/
public class ReachOasis {

    // 这题有个很简单的解法 因为只能用一个加油站，所以只要遍历所有加油站，看能不能到绿洲即可
    boolean solution(char[][] matrix, int gas) {
        int[] start = null;
        Queue<int[]> queue = new LinkedList<>(); // 存所有加油站的坐标
        int[] end = null;
        int m = matrix.length, n = matrix[0].length;
        // 先遍历一遍matrix，拿到起点和绿洲的坐标
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
        // 如果起点到绿洲的距离小于gas，可以直接到达
        if (Math.abs(end[0] - start[0]) + Math.abs(end[1] - start[1]) <= gas) return true;
        // 遍历所有加油站
        for (int[] index : queue) {
            // 先计算起点到加油站的距离，如果到不了加油站，说明这个加油站不能用，就continue
            int dist1 = Math.abs(start[0] - index[0]) + Math.abs(start[1] - index[1]);
            if (gas < dist1) continue;
            int cur = gas - dist1 + (matrix[index[0]][index[1]] - '0'); // 加完油的油量，也就是可以走的距离
            int dist2 = Math.abs(end[0] - index[0]) + Math.abs(end[1] - index[1]); // 绿洲到加油站的距离
            if (dist2 <= cur) return true;
        }
        return false;
    }
    
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

}

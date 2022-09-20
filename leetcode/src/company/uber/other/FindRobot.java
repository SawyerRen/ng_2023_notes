package company.uber.other;

import java.util.Arrays;

/**
 * 一个 m*n matrix, 有robot，empty cell, wall
 * 4 个数，分别代表某个robot在四个方向上和距离最近的wall的距离
 * output: 返回这个robot的坐标
 */
public class FindRobot {
    static class Node {
        int u = Integer.MAX_VALUE;
        int d = Integer.MAX_VALUE;
        int l = Integer.MAX_VALUE;
        int r = Integer.MAX_VALUE;
    }

    static int[] findRobot(int[][] matrix, int u, int d, int l, int r) {
        int dist = Integer.MAX_VALUE;
        int m = matrix.length, n = matrix[0].length;
        Node[][] nodes = new Node[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                nodes[i][j] = new Node();
            }
        }
        for (int i = 0; i < m; i++) {
            dist = Integer.MAX_VALUE;
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 1) {
                    dist = 0;
                } else {
                    if (dist != Integer.MAX_VALUE) {
                        dist++;
                        nodes[i][j].l = dist;
                    }
                }
            }
            dist = Integer.MAX_VALUE;
            for (int j = n - 1; j >= 0; j--) {
                if (matrix[i][j] == 1) {
                    dist = 0;
                } else {
                    if (dist != Integer.MAX_VALUE) {
                        dist++;
                        nodes[i][j].r = dist;
                    }
                }
            }
        }
        for (int j = 0; j < n; j++) {
            dist = Integer.MAX_VALUE;
            for (int i = 0; i < m; i++) {
                if (matrix[i][j] == 1) {
                    dist = 0;
                } else {
                    if (dist != Integer.MAX_VALUE) {
                        dist++;
                        nodes[i][j].u = dist;
                    }
                }
            }
            dist = Integer.MAX_VALUE;
            for (int i = m - 1; i >= 0; i--) {
                if (matrix[i][j] == 1) {
                    dist = 0;
                } else {
                    if (dist != Integer.MAX_VALUE) {
                        dist++;
                        nodes[i][j].d = dist;
                    }
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (nodes[i][j].d == d && nodes[i][j].l == l && nodes[i][j].r == r
                        && nodes[i][j].u == u) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[2];
    }

    public static void main(String[] args) {
        int[][] matrix = {{0, 1, 0, 0}, {1, 0, 0, 1}, {0, 1, 0, 0}};
        System.out.println(Arrays.toString(findRobot(matrix, Integer.MAX_VALUE, Integer.MAX_VALUE, 2, 1)));
    }
}

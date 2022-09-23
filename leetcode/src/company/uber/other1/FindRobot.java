package company.uber.other1;

/**
 * 一个 m*n matrix, 有robot，empty cell, wall
 * 4 个数，分别代表某个robot在四个方向上和距离最近的wall的距离
 * output: 返回这个robot的坐标
 */
public class FindRobot {
    class Node {
        int l = Integer.MAX_VALUE;
        int r = Integer.MAX_VALUE;
        int u = Integer.MAX_VALUE;
        int d = Integer.MAX_VALUE;
    }

    public int[] solution(int[][] board, int l, int r, int u, int d) {
        int m = board.length, n = board[0].length;
        Node[][] nodes = new Node[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                nodes[i][j] = new Node();
            }
        }
        int dist = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            dist = Integer.MAX_VALUE;
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 1) {
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
                if (board[i][j] == 1) {
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
                if (board[i][j] == 1) {
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
                if (board[i][j] == 1) {
                    dist = 0;
                } else {
                    if (dist != Integer.MAX_VALUE) {
                        dist++;
                        nodes[i][j].u = dist;
                    }
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (nodes[i][j].l == l && nodes[i][j].r == r && nodes[i][j].d == d && nodes[i][j].u == u) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[2];
    }
}

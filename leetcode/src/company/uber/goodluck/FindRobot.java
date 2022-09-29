package company.uber.goodluck;

public class FindRobot {
    class Node {
        int up = Integer.MAX_VALUE;
        int down = Integer.MAX_VALUE;
        int left = Integer.MAX_VALUE;
        int right = Integer.MAX_VALUE;
    }

    int[] solution(int[][] matrix, int up, int down, int left, int right) {
        int m = matrix.length, n = matrix[0].length;
        Node[][] nodes = new Node[m][n];
        int dist = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            dist = Integer.MAX_VALUE;
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 1) {
                    dist = 0;
                } else {
                    if (dist != Integer.MAX_VALUE) {
                        dist++;
                        nodes[i][j].left = dist;
                    }
                }
            }
            dist = Integer.MAX_VALUE;
            for (int j = n - 1; i >= 0; i--) {
                if (matrix[i][j] == 1) {
                    dist = 0;
                } else {
                    if (dist != Integer.MAX_VALUE) {
                        dist++;
                        nodes[i][j].right = dist;
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
                        nodes[i][j].up = dist;
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
                        nodes[i][j].down = dist;
                    }
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (nodes[i][j].left == left && nodes[i][j].right == right
                        && nodes[i][j].up == up && nodes[i][j].down == down) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{-1, -1};
    }
}

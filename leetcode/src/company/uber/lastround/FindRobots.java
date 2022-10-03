package company.uber.lastround;

public class FindRobots {
    class Node {
        int d = Integer.MAX_VALUE;
        int u = Integer.MAX_VALUE;
        int l = Integer.MAX_VALUE;
        int r = Integer.MAX_VALUE;
    }

    int[] solution(int[][] matrix, int d, int u, int l, int r) {
        int m = matrix.length, n = matrix[0].length;
        int diff = Integer.MAX_VALUE;
        Node[][] nodes = new Node[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                nodes[i][j] = new Node();
            }
        }
        for (int i = 0; i < m; i++) {
            diff = Integer.MAX_VALUE;
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 1) diff = 0;
                else {
                    if (diff != Integer.MAX_VALUE) {
                        nodes[i][j].l = diff + 1;
                        diff++;
                    }
                }
            }
            diff = Integer.MAX_VALUE;
            for (int j = n - 1; j >= 0; j--) {
                if (matrix[i][j] == 1) diff = 0;
                else {
                    if (diff != Integer.MAX_VALUE) {
                        nodes[i][j].r = diff + 1;
                        diff++;
                    }
                }
            }
        }
        for (int j = 0; j < n; j++) {
            diff = Integer.MAX_VALUE;
            for (int i = 0; i < m; i++) {
                if (matrix[i][j] == 1) diff = 0;
                else {
                    if (diff != Integer.MAX_VALUE) {
                        nodes[i][j].u = diff + 1;
                        diff++;
                    }
                }
            }
            for (int i = m - 1; i >= 0; i--) {
                if (matrix[i][j] == 1) diff = 0;
                else {
                    if (diff != Integer.MAX_VALUE) {
                        nodes[i][j].d = diff + 1;
                        if (nodes[i][j].d == d) return new int[]{i, j};
                        diff++;
                    }
                }
            }
        }
        return new int[]{-1, -1};
    }
}

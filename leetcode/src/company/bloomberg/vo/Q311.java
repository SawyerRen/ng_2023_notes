package company.bloomberg.vo;

import java.util.ArrayList;
import java.util.List;

public class Q311 {
    class Node {
        int row;
        int col;
        int val;

        public Node(int row, int col, int val) {
            this.row = row;
            this.col = col;
            this.val = val;
        }
    }

    public int[][] multiply(int[][] mat1, int[][] mat2) {
        int m1 = mat1.length, n1 = mat1[0].length;
        int m2 = mat2.length, n2 = mat2[0].length;
        List<Node> list1 = new ArrayList<>();
        List<Node> list2 = new ArrayList<>();
        for (int i = 0; i < m1; i++) {
            for (int j = 0; j < n1; j++) {
                if (mat1[i][j] != 0) list1.add(new Node(i, j, mat1[i][j]));
            }
        }
        for (int i = 0; i < m2; i++) {
            for (int j = 0; j < n2; j++) {
                if (mat2[i][j] != 0) list2.add(new Node(i, j, mat2[i][j]));
            }
        }
        int[][] res = new int[m1][n2];
        for (Node node1 : list1) {
            for (Node node2 : list2) {
                if (node1.col == node2.row) res[node1.row][node2.col] += node1.val * node2.val;
            }
        }
        return res;
    }
}

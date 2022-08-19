package company.uber.q300;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q305 {
    class UnionFind {
        int[] parents;
        int n;
        int count;

        public UnionFind(int n) {
            this.n = n;
            parents = new int[n];
            Arrays.fill(parents, -1);
            count = 0;
        }

        void init(int i) {
            if (parents[i] != -1) return;
            parents[i] = i;
            count++;
        }

        void union(int i, int j) {
            int p1 = find(i), p2 = find(j);
            if (p1 == p2) return;
            parents[p2] = p1;
            count--;
        }

        private int find(int i) {
            while (i != parents[i]) {
                parents[i] = parents[parents[i]];
                i = parents[i];
            }
            return i;
        }
    }

    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        int len = m * n;
        UnionFind uf = new UnionFind(len);
        List<Integer> res = new ArrayList<>();
        int[][] board = new int[m][n];
        int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        for (int[] position : positions) {
            int i = position[0], j = position[1];
            int index = i * n + j;
            uf.init(index);
            board[i][j] = 1;
            for (int[] dir : dirs) {
                int x = i + dir[0], y = j + dir[1];
                if (x < 0 || x >= m || y < 0 || y >= n || board[x][y] == 0) continue;
                int index2 = x * n + y;
                uf.union(index, index2);
            }
            res.add(uf.count);
        }
        return res;
    }
}

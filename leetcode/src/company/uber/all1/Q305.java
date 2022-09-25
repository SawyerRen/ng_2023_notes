package company.uber.all1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q305 {
    class UnionFind {
        int[] parents;
        int count = 0;

        public UnionFind(int n) {
            parents = new int[n];
            Arrays.fill(parents, -1);
        }

        void init(int i) {
            if (parents[i] == -1) {
                parents[i] = i;
                count++;
            }
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

    int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        UnionFind uf = new UnionFind(m * n);
        List<Integer> list = new ArrayList<>();
        for (int[] p : positions) {
            int index = p[0] * n + p[1];
            uf.init(index);
            for (int[] dir : dirs) {
                int x = p[0] + dir[0], y = p[1] + dir[1];
                if (x < 0 || x >= m || y < 0 || y >= n) continue;
                int index2 = x * n + y;
                if (uf.parents[index2] != -1) {
                    uf.union(index, index2);
                }
            }
            list.add(uf.count);
        }
        return list;
    }
}

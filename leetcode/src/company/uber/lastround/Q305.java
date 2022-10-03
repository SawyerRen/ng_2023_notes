package company.uber.lastround;

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

        int find(int i) {
            while (i != parents[i]) {
                parents[i] = parents[parents[i]];
                i = parents[i];
            }
            return i;
        }

        void union(int i, int j) {
            int p1 = find(i), p2 = find(j);
            if (p1 == p2) return;
            parents[p2] = p1;
            count--;
        }

        void init(int i) {
            if (parents[i] == -1) {
                parents[i] = i;
                count++;
            }
        }
    }

    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> res = new ArrayList<>();
        UnionFind uf = new UnionFind(m * n);
        int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        for (int[] p : positions) {
            int i = p[0], j = p[1];
            int index = i * n + j;
            uf.init(index);
            for (int[] dir : dirs) {
                int x = i + dir[0], y = j + dir[1];
                if (x < 0 || x >= m || y < 0 || y >= n) continue;
                int index2 = x * n + y;
                if (uf.parents[index2] != -1) {
                    uf.union(index, index2);
                }
            }
            res.add(uf.count);
        }
        return res;
    }
}

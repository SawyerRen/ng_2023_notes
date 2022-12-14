package company.uber.q300;

import java.lang.reflect.Array;
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
    }

    int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> res = new ArrayList<>();
        UnionFind uf = new UnionFind(m * n);
        for (int[] position : positions) {
            int index = position[0] * n + position[1];
            uf.init(index);
            for (int[] dir : dirs) {
                int x = position[0] + dir[0], y = position[1] + dir[1];
                if (x < 0 || x >= m || y < 0 || y >= n) continue;
                int i = x * n + y;
                if (uf.parents[i] != -1)
                    uf.union(index, i);
            }
            res.add(uf.count);
        }
        return res;
    }
}

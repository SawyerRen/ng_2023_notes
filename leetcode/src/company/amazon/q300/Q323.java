package company.amazon.q300;

public class Q323 {
    int res = 0;

    public int countComponents(int n, int[][] edges) {
        int[] parents = new int[n];
        for (int i = 0; i < n; i++) {
            parents[i] = i;
        }
        res = n;
        for (int[] edge : edges) {
            union(parents, edge[0], edge[1]);
        }
        return res;
    }

    private void union(int[] parents, int i, int j) {
        int p1 = find(parents, i);
        int p2 = find(parents, j);
        if (p1 == p2) return;
        parents[p2] = p1;
        res--;
    }

    private int find(int[] parents, int i) {
        while (i != parents[i]) {
            parents[i] = parents[parents[i]];
            i = parents[i];
        }
        return i;
    }
}

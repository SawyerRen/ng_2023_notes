package company.amazon.q500;

public class Q547 {
    int size;

    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int[] parents = new int[n];
        size = n;
        for (int i = 0; i < n; i++) {
            parents[i] = i;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (isConnected[i][j] == 1) {
                    union(parents, i, j);
                }
            }
        }
        return size;
    }

    private void union(int[] parents, int i, int j) {
        int p1 = find(parents, i);
        int p2 = find(parents, j);
        if (p1 == p2) return;
        parents[p2] = p1;
        size--;
    }

    private int find(int[] parents, int i) {
        while (i != parents[i]) {
            parents[i] = parents[parents[i]];
            i = parents[i];
        }
        return i;
    }
}

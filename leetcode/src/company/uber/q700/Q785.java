package company.uber.q700;

public class Q785 {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] colors = new int[n];
        for (int i = 0; i < n; i++) {
            if (colors[i] == 0) {
                if (!dfs(colors, i, graph, 1)) return false;
            }
        }
        return true;
    }

    private boolean dfs(int[] colors, int i, int[][] graph, int color) {
        if (colors[i] != 0) return colors[i] == color;
        colors[i] = color;
        for (int next : graph[i]) {
            if (!dfs(colors, next, graph, -color)) return false;
        }
        return true;
    }
}

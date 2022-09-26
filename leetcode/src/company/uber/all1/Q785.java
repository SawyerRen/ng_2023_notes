package company.uber.all1;

public class Q785 {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] colors = new int[n];
        for (int i = 0; i < n; i++) {
            if (colors[i] == 0 && !helper(graph, i, colors, 1)) return false;
        }
        return true;
    }

    private boolean helper(int[][] graph, int i, int[] colors, int color) {
        if (colors[i] != 0) return colors[i] == color;
        colors[i] = color;
        for (int next : graph[i]) {
            if (!helper(graph, next, colors, -color)) return false;
        }
        return true;
    }
}

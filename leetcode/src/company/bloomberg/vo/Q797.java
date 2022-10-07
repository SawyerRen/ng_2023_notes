package company.bloomberg.vo;

import java.util.ArrayList;
import java.util.List;

public class Q797 {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        path.add(0);
        boolean[] visited = new boolean[graph.length];
        visited[0] = true;
        helper(res, path, graph, 0, graph.length - 1, visited);
        return res;
    }

    private void helper(List<List<Integer>> res, List<Integer> path, int[][] graph, int start, int end, boolean[] visited) {
        if (start == end) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int next : graph[start]) {
            if (visited[next]) continue;
            path.add(next);
            visited[next] = true;
            helper(res, path, graph, next, end, visited);
            path.remove(path.size() - 1);
            visited[next] = false;
        }
    }
}

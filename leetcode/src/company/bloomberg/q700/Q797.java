package company.bloomberg.q700;

import java.util.ArrayList;
import java.util.List;

public class Q797 {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        list.add(0);
        dfs(res, list, graph, 0, graph.length - 1, new boolean[graph.length]);
        return res;
    }

    private void dfs(List<List<Integer>> res, List<Integer> list, int[][] graph, int start, int end, boolean[] visited) {
        if (end == start) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int next : graph[start]) {
            if (visited[next]) continue;
            list.add(next);
            visited[next] = true;
            dfs(res, list, graph, next, end, visited);
            list.remove(list.size() - 1);
            visited[next] = false;
        }
    }
}

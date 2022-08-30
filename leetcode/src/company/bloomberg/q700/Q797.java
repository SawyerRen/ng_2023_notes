package company.bloomberg.q700;

import java.util.ArrayList;
import java.util.List;

public class Q797 {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        list.add(0);
        dfs(res, graph, list, 0, graph.length - 1, new boolean[graph.length]);
        return res;
    }

    private void dfs(List<List<Integer>> res, int[][] graph, List<Integer> list, int start, int end, boolean[] visited) {
        if (start == end) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int next : graph[start]) {
            if (visited[next]) continue;
            visited[next] = true;
            list.add(next);
            dfs(res, graph, list, next, end, visited);
            visited[next] = false;
            list.remove(list.size() - 1);
        }
    }
}

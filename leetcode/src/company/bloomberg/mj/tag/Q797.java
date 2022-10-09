package company.bloomberg.mj.tag;

import java.util.ArrayList;
import java.util.List;

public class Q797 {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        list.add(0);
        boolean[] visited = new boolean[graph.length];
        visited[0] = true;
        helper(res, list, graph, 0, graph.length - 1, visited);
        return res;
    }

    private void helper(List<List<Integer>> res, List<Integer> list, int[][] graph, int s, int e, boolean[] visited) {
        if (s == e) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int next : graph[s]) {
            if (visited[next]) continue;
            visited[next] = true;
            list.add(next);
            helper(res, list, graph, next, e, visited);
            visited[next] = false;
            list.remove(list.size() - 1);
        }
    }
}

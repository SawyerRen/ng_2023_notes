package company.bloomberg.goodluck;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Q797 {
    // 2^n * n
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        path.add(0);
        Set<Integer> visited = new HashSet<>();
        visited.add(0);
        helper(res, path, visited, 0, graph.length - 1, graph);
        return res;
    }

    private void helper(List<List<Integer>> res, List<Integer> path, Set<Integer> visited, int start, int end, int[][] graph) {
        if (start == end) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int next : graph[start]) {
            if (visited.contains(next)) continue;
            visited.add(next);
            path.add(next);
            helper(res, path, visited, next, end, graph);
            visited.remove(next);
            path.remove(path.size() - 1);
        }
    }
}

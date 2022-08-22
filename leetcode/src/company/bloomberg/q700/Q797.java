package company.bloomberg.q700;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Q797 {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res = new ArrayList<>();
        helper(graph, res, new ArrayList<Integer>(), 0, graph.length - 1, new HashSet<Integer>());
        return res;
    }

    private void helper(int[][] graph, List<List<Integer>> res, ArrayList<Integer> list, int source, int target, HashSet<Integer> visited) {
        list.add(source);
        visited.add(source);
        if (source == target) {
            res.add(new ArrayList<>(list));
            list.remove(list.size() - 1);
            visited.remove(source);
            return;
        }
        for (int next : graph[source]) {
            if (visited.contains(next)) continue;
            helper(graph, res, list, next, target, visited);
        }
        list.remove(list.size() - 1);
        visited.remove(source);
    }
}

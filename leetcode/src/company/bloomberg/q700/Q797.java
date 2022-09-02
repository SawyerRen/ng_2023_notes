package company.bloomberg.q700;

import java.util.ArrayList;
import java.util.List;

public class Q797 {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
//        list.add(0);
        dfs(res, list, graph, 0, graph.length - 1);
        return res;
    }

    private void dfs(List<List<Integer>> res, List<Integer> list, int[][] graph, int start, int end) {
        list.add(start);
        if (start == end) {
            res.add(new ArrayList<>(list));
            list.remove(list.size() - 1);
            return;
        }
        for (int next : graph[start]) {
//            list.add(next);
            dfs(res, list, graph, next, end);
//            list.remove(list.size() - 1);
        }
        list.remove(list.size() - 1);
    }
}

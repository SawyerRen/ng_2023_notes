package company.bloomberg.goodluck;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Q797 {
    // 2^n * n
    // 这题是标准的DFS，中间加上了backtrack
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res = new ArrayList<>(); 
        List<Integer> path = new ArrayList<>(); // 保存当前的路径
        Set<Integer> visited = new HashSet<>(); // 保存访问过的节点
        helper(res, path, visited, 0, graph.length - 1, graph);
        return res;
    }

    private void helper(List<List<Integer>> res, List<Integer> path, Set<Integer> visited, int cur, int end, int[][] graph) {
        // 把当前节点加入path和visited
        path.add(cur);
        visited.add(cur);
        // 如果到了终点，path加入到res中
        if (cur == end) {
            res.add(new ArrayList<>(path));
        } else {
            // 否则，查看所有的next节点，继续DFS
            for (int next : graph[cur]) {
                if (visited.contains(next)) continue;
                helper(res, path, visited, next, end, graph);
            }
        }
        // 最后记得要backtrack
        visited.remove(cur);
        path.remove(path.size() - 1);
    }
}

package company.bloomberg.vo;

import javafx.util.Pair;

import java.util.*;

public class Q1129 {
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        int[][] graph = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(graph[i], -n);
        }
        for (int[] edge : redEdges) {
            graph[edge[0]][edge[1]] = 1;
        }
        for (int[] edge : blueEdges) {
            if (graph[edge[0]][edge[1]] == 1) graph[edge[0]][edge[1]] = 0;
            else graph[edge[0]][edge[1]] = -1;
        }
        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.add(new Pair<>(0, 1));
        queue.add(new Pair<>(0, -1));
        int[] res = new int[n];
        Arrays.fill(res, Integer.MAX_VALUE);
        int len = 0;
        res[len] = 0;
        while (!queue.isEmpty()) {
            len++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Pair<Integer, Integer> poll = queue.poll();
                int node = poll.getKey();
                int color = poll.getValue();
                int nextColor = -color;
                for (int j = 1; j < n; j++) {
                    if (graph[node][j] == nextColor || graph[node][j] == 0) {
                        if (visited.contains(j + " " + nextColor)) continue;
                        visited.add(j + " " + nextColor);
                        queue.add(new Pair<>(j, nextColor));
                        res[j] = Math.min(res[j], len);
                    }
                }
            }
        }
        for (int i = 1; i < n; i++) {
            if (res[i] == Integer.MAX_VALUE) res[i] = -1;
        }
        return res;
    }
}

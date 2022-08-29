package company.uber.q800;

import java.util.*;

public class Q815 {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        Map<Integer, Set<Integer>> stop2Route = new HashMap<>();
        for (int i = 0; i < routes.length; i++) {
            for (int stop : routes[i]) {
                stop2Route.putIfAbsent(stop, new HashSet<>());
                stop2Route.get(stop).add(i);
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.add(source);
        Set<Integer> visitedStops = new HashSet<>();
        Set<Integer> visitedRoutes = new HashSet<>();
        int res = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Integer poll = queue.poll();
                if (poll == target) return res;
                for (Integer route : stop2Route.get(poll)) {
                    if (visitedRoutes.contains(route)) continue;
                    visitedRoutes.add(route);
                    for (int nextStop : routes[route]) {
                        if (visitedStops.contains(nextStop)) continue;
                        visitedStops.add(nextStop);
                        queue.add(nextStop);
                    }
                }
            }
            res++;
        }
        return -1;
    }
}

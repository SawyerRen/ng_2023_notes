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
        Set<Integer> visitedStops = new HashSet<>();
        Set<Integer> visitedRoutes = new HashSet<>();
        visitedStops.add(source);
        queue.add(source);
        int res = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Integer stop = queue.poll();
                if (stop == target) return res;
                for (Integer nextRoute : stop2Route.get(stop)) {
                    if (visitedRoutes.contains(nextRoute)) continue;
                    visitedRoutes.add(nextRoute);
                    for (int nextStop : routes[nextRoute]) {
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

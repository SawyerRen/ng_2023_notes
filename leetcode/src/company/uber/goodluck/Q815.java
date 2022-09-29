package company.uber.goodluck;

import java.util.*;

public class Q815 {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < routes.length; i++) {
            for (int stop : routes[i]) {
                map.putIfAbsent(stop, new HashSet<>());
                map.get(stop).add(i);
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        int res = 0;
        Set<Integer> visitedStops = new HashSet<>();
        Set<Integer> visitedRoutes = new HashSet<>();
        queue.add(source);
        visitedStops.add(source);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Integer stop = queue.poll();
                if (stop == target) return res;
                for (Integer nextRoute : map.get(stop)) {
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

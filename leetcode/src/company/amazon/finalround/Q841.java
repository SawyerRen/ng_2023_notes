package company.amazon.finalround;

import java.util.*;

public class Q841 {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        queue.add(0);
        visited.add(0);
        int count = 0;
        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            count++;
            if (count == rooms.size()) return true;
            for (Integer next : rooms.get(poll)) {
                if (visited.contains(next)) continue;
                queue.add(next);
                visited.add(next);
            }
        }
        return false;
    }
}

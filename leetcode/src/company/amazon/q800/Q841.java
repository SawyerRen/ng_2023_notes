package company.amazon.q800;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Q841 {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[rooms.size()];
        queue.add(0);
        visited[0] = true;
        int count = 0;
        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            count++;
            if (count == rooms.size()) return true;
            for (Integer next : rooms.get(poll)) {
                if (visited[next]) continue;
                visited[next] = true;
                queue.add(next);
            }
        }
        return false;
    }
}

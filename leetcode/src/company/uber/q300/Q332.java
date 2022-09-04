package company.uber.q300;

import java.util.*;

public class Q332 {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> map = new HashMap<>();
        for (List<String> ticket : tickets) {
            map.putIfAbsent(ticket.get(0), new PriorityQueue<>());
            map.get(ticket.get(0)).add(ticket.get(1));
        }
        LinkedList<String> res = new LinkedList<>();
        helper(res, map, "JFK");
        return res;
    }

    private void helper(LinkedList<String> res, Map<String, PriorityQueue<String>> map, String airport) {
        PriorityQueue<String> pq = map.get(airport);
        while (pq != null && !pq.isEmpty()) {
            helper(res, map, pq.poll());
        }
        res.addFirst(airport);
    }
}

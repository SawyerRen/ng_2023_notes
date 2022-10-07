package company.bloomberg.vo;

import java.util.*;

public class Q332 {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> map = new HashMap<>();
        for (List<String> ticket : tickets) {
            map.putIfAbsent(ticket.get(0), new PriorityQueue<>());
            map.get(ticket.get(0)).add(ticket.get(1));
        }
        LinkedList<String> list = new LinkedList<>();
        helper(map, list, "JFK");
        return list;
    }

    private void helper(Map<String, PriorityQueue<String>> map, LinkedList<String> list, String airport) {
        PriorityQueue<String> pq = map.get(airport);
        while (pq != null && !pq.isEmpty()) {
            helper(map, list, pq.poll());
        }
        list.addFirst(airport);
    }
}

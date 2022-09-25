package company.uber.all1;

import java.util.*;

public class Q332 {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> map = new HashMap<>();
        for (List<String> ticket : tickets) {
            String s = ticket.get(0);
            String e = ticket.get(1);
            map.putIfAbsent(s, new PriorityQueue<>());
            map.get(s).add(e);
        }
        LinkedList<String> res = new LinkedList<>();
        helper(map, res, "JFK");
        return res;
    }

    private void helper(Map<String, PriorityQueue<String>> map, LinkedList<String> res, String airport) {
        PriorityQueue<String> pq = map.get(airport);
        while (pq != null && !pq.isEmpty()) {
            helper(map, res, pq.poll());
        }
        res.addFirst(airport);
    }
}

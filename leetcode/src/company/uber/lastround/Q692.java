package company.uber.lastround;

import java.util.*;

public class Q692 {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        PriorityQueue<String> pq = new PriorityQueue<>((a, b) -> map.get(a) == map.get(b) ? b.compareTo(a) : map.get(a) - map.get(b));
        for (String s : map.keySet()) {
            pq.add(s);
            if (pq.size() > k) pq.poll();
        }
        LinkedList<String> res = new LinkedList<>();
        while (!pq.isEmpty()) {
            res.addFirst(pq.poll());
        }
        return res;
    }
}

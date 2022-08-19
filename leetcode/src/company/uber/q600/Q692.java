package company.uber.q600;

import java.util.*;

public class Q692 {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        LinkedList<String> res = new LinkedList<>();
        PriorityQueue<String> pq = new PriorityQueue<>((a, b) -> {
            if (map.get(a).equals(map.get(b))) return b.compareTo(a);
            return map.get(a) - map.get(b);
        });
        for (String word : map.keySet()) {
            pq.add(word);
            if (pq.size() > k) pq.poll();
        }
        while (!pq.isEmpty()) {
            res.addFirst(pq.poll());
        }
        return res;
    }
}

package company.uber.all1;

import java.util.*;

public class Q692 {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        PriorityQueue<String> pq = new PriorityQueue<>((a, b) -> map.get(a) == map.get(b) ? b.compareTo(a) : map.get(a) - map.get(b));
        for (String word : map.keySet()) {
            pq.add(word);
            if (pq.size() > k) pq.poll();
        }
        LinkedList<String> list = new LinkedList<>();
        while (!pq.isEmpty()) {
            list.addFirst(pq.poll());
        }
        return list;
    }
}

package company.uber.all1;

import java.util.*;

public class Q692 {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        List[] lists = new List[words.length + 1];
        for (String s : map.keySet()) {
            Integer count = map.get(s);
            if (lists[count] == null) lists[count] = new ArrayList<String>();
            lists[count].add(s);
        }
        List<String> res = new ArrayList<>();
        for (int i = words.length; i >= 0 && k > 0; i--) {
            if (lists[i] != null) {
                List<String> list = lists[i];
                list.sort((a, b) -> a.compareTo(b));
                for (String s : list) {
                    if (k == 0) break;
                    res.add(s);
                    k--;
                }
            }
        }
        return res;
    }

    public List<String> topKFrequent1(String[] words, int k) {
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

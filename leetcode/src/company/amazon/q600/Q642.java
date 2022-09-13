package company.amazon.q600;

import java.util.*;

public class Q642 {
    class Node {
        Node[] children = new Node[256];
        Map<String, Integer> map = new HashMap<>();
    }

    class AutocompleteSystem {
        Node root = new Node();
        Node cur = root;
        StringBuilder builder = new StringBuilder();

        public AutocompleteSystem(String[] sentences, int[] times) {
            for (int i = 0; i < sentences.length; i++) {
                Node cur = root;
                for (char c : sentences[i].toCharArray()) {
                    if (cur.children[c] == null) cur.children[c] = new Node();
                    cur = cur.children[c];
                    cur.map.put(sentences[i], times[i]);
                }
            }
        }

        public List<String> input(char c) {
            if (c == '#') {
                Node temp = root;
                for (char c1 : builder.toString().toCharArray()) {
                    if (temp.children[c1] == null) temp.children[c1] = new Node();
                    temp = temp.children[c1];
                    temp.map.put(builder.toString(), temp.map.getOrDefault(builder.toString(), 0) + 1);
                }
                cur = root;
                builder = new StringBuilder();
                return new ArrayList<>();
            }
            builder.append(c);
            if (cur.children[c] == null) {
                return new ArrayList<>();
            } else {
                cur = cur.children[c];
                return getList(cur.map);
            }
        }

        private List<String> getList(Map<String, Integer> map) {
            PriorityQueue<String> pq = new PriorityQueue<>((a, b) -> map.get(a).equals(map.get(b)) ? b.compareTo(a) : map.get(a) - map.get(b));
            for (String s : map.keySet()) {
                pq.add(s);
                if (pq.size() > 3) pq.poll();
            }
            LinkedList<String> list = new LinkedList<>();
            while (!pq.isEmpty()) list.addFirst(pq.poll());
            return list;
        }
    }
}

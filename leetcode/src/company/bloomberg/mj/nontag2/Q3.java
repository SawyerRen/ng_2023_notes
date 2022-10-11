package company.bloomberg.mj.nontag2;

import java.util.*;

public class Q3 {
    class Node {
        char c;
    }

    LinkedList<Node> list = new LinkedList<>();
    Map<Character, Node> map = new HashMap<>();
    Set<Character> duplicate = new HashSet<>();

    void add(char c) {
        if (duplicate.contains(c)) return;
        if (map.containsKey(c)) {
            duplicate.add(c);
            list.remove(map.get(c));
        } else {
            Node node = new Node();
            node.c = c;
            list.addLast(node);
            map.put(c, node);
        }
    }
}

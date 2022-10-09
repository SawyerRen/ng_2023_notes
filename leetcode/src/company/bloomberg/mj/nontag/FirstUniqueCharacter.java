package company.bloomberg.mj.nontag;

import java.util.*;

public class FirstUniqueCharacter {
    class Node {
        char c;

        public Node(char c) {
            this.c = c;
        }
    }

    LinkedList<Node> linkedList = new LinkedList<>();
    Map<Character, Node> map = new HashMap<>();
    Set<Character> duplicate = new HashSet<>();

    public FirstUniqueCharacter() {
    }

    void add(char c) {
        if (duplicate.contains(c)) return;
        if (map.containsKey(c)) {
            linkedList.remove(map.get(c));
            duplicate.add(c);
        } else {
            Node node = new Node(c);
            map.put(c, node);
            linkedList.addLast(node);
        }
    }

    char getFirstChar() {
        return linkedList.getFirst().c;
    }
}

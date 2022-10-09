package company.bloomberg.r2;

import java.util.*;

public class FirstUniqueCharacter {
//    class Node {
//        char c;
//
//        public Node(char c) {
//            this.c = c;
//        }
//    }
//
//    LinkedList<Node> linkedList = new LinkedList<>();
//    Map<Character, Node> map = new HashMap<>();
//    Set<Character> duplicate = new HashSet<>();
//
//    void add(char c) {
//        if (duplicate.contains(c)) return;
//        if (map.containsKey(c)) {
//            linkedList.remove(map.get(c));
//            duplicate.add(c);
//        } else {
//            Node node = new Node(c);
//            map.put(c, node);
//            linkedList.addLast(node);
//        }
//    }
//
//    char getFirstUnique() {
//        return linkedList.peekFirst().c;
//    }

    LinkedHashSet<Character> unique = new LinkedHashSet<>();
    Set<Character> duplicate = new HashSet<>();

    void add(char c) {
        if (duplicate.contains(c)) return;
        if (unique.contains(c)) {
            duplicate.add(c);
            unique.remove(c);
        } else {
            unique.add(c);
        }
    }

    char getFirstUnique() {
        return unique.iterator().next();
    }
}

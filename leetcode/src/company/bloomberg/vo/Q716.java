package company.bloomberg.vo;

import java.util.LinkedList;
import java.util.TreeMap;

public class Q716 {
    class Node {
        int val;

        public Node(int val) {
            this.val = val;
        }
    }

    class MaxStack {
        TreeMap<Integer, LinkedList<Node>> map = new TreeMap<>();
        LinkedList<Node> list = new LinkedList<>();

        public MaxStack() {

        }

        public void push(int x) {
            Node node = new Node(x);
            list.addLast(node);
            map.putIfAbsent(x, new LinkedList<>());
            map.get(x).addLast(node);
        }

        public int pop() {
            Node node = list.removeLast();
            map.get(node.val).removeLast();
            if (map.get(node.val).size() == 0) map.remove(node.val);
            return node.val;
        }

        public int top() {
            return list.getLast().val;
        }

        public int peekMax() {
            return map.lastKey();
        }

        public int popMax() {
            LinkedList<Node> nodes = map.get(map.lastKey());
            Node node = nodes.removeLast();
            list.remove(node);
            if (map.get(node.val).size() == 0) map.remove(node.val);
            return node.val;
        }
    }
}

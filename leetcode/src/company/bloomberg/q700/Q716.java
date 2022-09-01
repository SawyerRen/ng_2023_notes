package company.bloomberg.q700;

import java.util.*;

public class Q716 {
    class Node {
        int val;

        public Node(int val) {
            this.val = val;
        }
    }

    class MaxStack {
        Deque<Node> list = new LinkedList<>();
        TreeMap<Integer, List<Node>> map = new TreeMap<>();

        public MaxStack() {

        }

        public void push(int x) {
            Node node = new Node(x);
            list.addLast(node);
            map.putIfAbsent(x, new ArrayList<>());
            map.get(x).add(node);
        }

        public int pop() {
            Node node = list.removeLast();
            List<Node> nodes = map.get(node.val);
            nodes.remove(nodes.size() - 1);
            if (nodes.size() == 0) map.remove(node.val);
            return node.val;
        }

        public int top() {
            return list.getLast().val;
        }

        public int peekMax() {
            return map.lastKey();
        }

        public int popMax() {
            int max = map.lastKey();
            List<Node> nodes = map.get(max);
            Node remove = nodes.remove(nodes.size() - 1);
            if (nodes.size() == 0) map.remove(max);
            list.remove(remove);
            return max;
        }
    }
}

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
        Deque<Node> deque = new LinkedList<>();
        TreeMap<Integer, List<Node>> map = new TreeMap<>();

        public MaxStack() {

        }

        public void push(int x) {
            Node node = new Node(x);
            deque.addLast(node);
            map.putIfAbsent(x, new ArrayList<>());
            map.get(x).add(node);
        }

        public int pop() {
            Node node = deque.removeLast();
            List<Node> list = map.get(node.val);
            list.remove(list.size() - 1);
            if (list.size() == 0) map.remove(node.val);
            return node.val;
        }

        public int top() {
            return deque.peekLast().val;
        }

        public int peekMax() {
            return map.lastKey();
        }

        public int popMax() {
            int max = map.lastKey();
            List<Node> list = map.get(max);
            Node remove = list.remove(list.size() - 1);
            if (list.size() == 0) map.remove(max);
            deque.remove(remove);
            return max;
        }
    }
}

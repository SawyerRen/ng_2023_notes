package company.bloomberg.q700;

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
        TreeMap<Integer, LinkedList<Node>> treeMap = new TreeMap<>();
        LinkedList<Node> nodes = new LinkedList<>();

        public MaxStack() {

        }

        public void push(int x) {
            Node node = new Node(x);
            nodes.addLast(node);
            treeMap.putIfAbsent(x, new LinkedList<>());
            treeMap.get(x).addLast(node);
        }

        public int pop() {
            Node node = nodes.removeLast();
            LinkedList<Node> list = treeMap.get(node.val);
            list.removeLast();
            if (list.size() == 0) treeMap.remove(node.val);
            return node.val;
        }

        public int top() {
            return nodes.getLast().val;
        }

        public int peekMax() {
            return treeMap.lastKey();
        }

        public int popMax() {
            int max = peekMax();
            LinkedList<Node> list = treeMap.get(max);
            Node node = list.removeLast();
            nodes.remove(node);
            if (list.size() == 0) treeMap.remove(max);
            return max;
        }
    }
}

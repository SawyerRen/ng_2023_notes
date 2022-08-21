package company.amazon.q100;

import java.util.HashMap;
import java.util.Map;

public class Q146 {
    class LRUCache {
        Map<Integer, Node> map = new HashMap<>();
        NodeList nodeList = new NodeList();
        int capacity;

        public LRUCache(int capacity) {
            this.capacity = capacity;
        }

        public int get(int key) {
            if (!map.containsKey(key)) return -1;
            Node node = map.get(key);
            put(key, node.value);
            return node.value;
        }

        public void put(int key, int value) {
            Node node = new Node(key, value);
            if (map.containsKey(key)) {
                nodeList.remove(map.get(key));
            } else {
                if (nodeList.size == capacity) {
                    int lastKey = nodeList.removeLast();
                    map.remove(lastKey);
                }
            }
            map.put(key, node);
            nodeList.addFirst(node);
        }
    }

    class NodeList {
        Node head;
        Node tail;
        int size;

        public NodeList() {
            head = new Node();
            tail = new Node();
            head.next = tail;
            tail.pre = head;
            size = 0;
        }

        void addFirst(Node node) {
            node.next = head.next;
            node.next.pre = node;
            node.pre = head;
            head.next = node;
            size++;
        }

        void remove(Node node) {
            node.pre.next = node.next;
            node.next.pre = node.pre;
            size--;
        }

        int removeLast() {
            Node last = tail.pre;
            last.pre.next = tail;
            tail.pre = last.pre;
            size--;
            return last.key;
        }
    }

    class Node {
        int key;
        int value;
        Node pre;
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }

        public Node() {
        }
    }
}

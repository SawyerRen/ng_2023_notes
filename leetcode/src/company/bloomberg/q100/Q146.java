package company.bloomberg.q100;

import java.util.HashMap;
import java.util.Map;

public class Q146 {
    class LRUCache {
        DoubleList list = new DoubleList();
        Map<Integer, Node> map = new HashMap<>();
        int capacity;

        public LRUCache(int capacity) {
            this.capacity = capacity;
        }

        public int get(int key) {
            if (!map.containsKey(key)) return -1;
            Node node = map.get(key);
            put(node.key, node.val);
            return node.val;
        }

        public void put(int key, int value) {
            Node node = new Node(key, value);
            if (map.containsKey(key)) {
                Node remove = map.remove(key);
                list.remove(remove);
            } else {
                if (list.size == capacity) {
                    int lastKey = list.removeLast();
                    map.remove(lastKey);
                }
            }
            map.put(key, node);
            list.addFirst(node);
        }
    }

    class DoubleList {
        Node head = new Node();
        Node tail = new Node();
        int size;

        public DoubleList() {
            head.next = tail;
            tail.pre = head;
        }

        void addFirst(Node node) {
            node.next = head.next;
            node.next.pre = node;
            head.next = node;
            node.pre = head;
            size++;
        }

        void remove(Node node) {
            node.pre.next = node.next;
            node.next.pre = node.pre;
            size--;
        }

        int removeLast() {
            Node node = tail.pre;
            node.pre.next = tail;
            tail.pre = node.pre;
            size--;
            return node.key;
        }
    }

    class Node {
        int key;
        int val;
        Node pre;
        Node next;

        public Node() {
        }

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
}

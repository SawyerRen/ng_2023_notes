package company.bloomberg.q100;

import java.util.HashMap;
import java.util.Map;

public class Q146 {
    class LRUCache {
        Map<Integer, Node> map = new HashMap<>();
        DLL list = new DLL();
        int capacity;

        public LRUCache(int capacity) {
            this.capacity = capacity;
        }

        public int get(int key) {
            if (!map.containsKey(key)) return -1;
            Node node = map.get(key);
            put(key, node.val);
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

    class DLL {
        Node head;
        Node tail;
        int size;

        public DLL() {
            head = new Node();
            tail = new Node();
            size = 0;
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
            node.next.pre = node.pre;
            node.pre.next = node.next;
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

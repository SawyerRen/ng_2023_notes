package company.amazon.q100;

import java.util.HashMap;
import java.util.Map;

public class Q146 {
    class LRUCache {
        DLL list = new DLL();
        Map<Integer, Node> map = new HashMap<>();
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
                list.remove(map.get(key));
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
        Node head = new Node();
        Node tail = new Node();
        int size;

        public DLL() {
            head.next = tail;
            tail.pre = head;
        }

        void addFirst(Node node) {
            node.next = head.next;
            head.next.pre = node;
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
            last.next.pre = last.pre;
            last.pre.next = last.next;
            size--;
            return last.key;
        }
    }

    class Node {
        Node pre;
        Node next;
        int key;
        int val;

        public Node() {
        }

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
}

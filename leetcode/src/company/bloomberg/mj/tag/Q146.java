package company.bloomberg.mj.tag;

import java.util.HashMap;
import java.util.LinkedList;
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
            put(key, node.value);
            return node.value;
        }

        public void put(int key, int value) {
            Node node = new Node(key, value);
            if (map.containsKey(key)) {
                Node remove = map.remove(key);
                list.remove(remove);
            } else {
                if (capacity == list.size) {
                    int last = list.removeLast();
                    map.remove(last);
                }
            }
            map.put(key, node);
            list.addFirst(node);
        }
    }

    class DLL {
        Node head = new Node();
        Node tail = new Node();
        int size = 0;

        public DLL() {
            head.next = tail;
            tail.pre = head;
        }

        void addFirst(Node node) {
            node.next = head.next;
            head.next.pre = node;
            head.next = node;
            node.pre = head;
            size++;
        }

        void remove(Node node) {
            node.next.pre = node.pre;
            node.pre.next = node.next;
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
        int value;
        Node pre;
        Node next;

        public Node() {
        }

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}

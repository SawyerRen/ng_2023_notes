package company.bloomberg.goodluck;

import java.util.HashMap;
import java.util.Map;

public class Q146 {
    class BrowserHistory {
        Map<String, Node> map = new HashMap<>();
        DLL list = new DLL();
        int capacity;

        public BrowserHistory(int capacity) {
            this.capacity = capacity;
        }

        void insert(String url) {
            Node node = new Node(url);
            if (map.containsKey(url)) {
                Node remove = map.remove(url);
                list.remove(remove);
            } else {
                if (this.capacity == list.size) {
                    String last = list.removeLast();
                    map.remove(last);
                }
            }
            list.addFirst(node);
            map.put(url, node);
        }

        void display() {
            list.printList();
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
            node.pre = head;
            node.next = head.next;
            head.next.pre = node;
            head.next = node;
            size++;
        }

        void remove(Node node) {
            node.pre.next = node.next;
            node.next.pre = node.pre;
            size--;
        }

        String removeLast() {
            Node node = tail.pre;
            node.pre.next = node.next;
            node.next.pre = node.pre;
            size--;
            return node.url;
        }

        void printList() {
            Node cur = head;
            while (cur.next != tail) {
                System.out.println(cur.next.url);
                cur = cur.next;
            }
        }
    }

    class Node {
        String url;
        Node pre;
        Node next;

        public Node() {
        }

        public Node(String url) {
            this.url = url;
        }
    }
}

package company.amazon.ood.finalround;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class SetWithExpiration {
    class Node {
        String key;
        String value;
        long timestamp;

        public Node(String key, String value, long timestamp) {
            this.key = key;
            this.value = value;
            this.timestamp = timestamp;
        }

        boolean shouldRemove(long expirationTime) {
            return this.timestamp + expirationTime < System.currentTimeMillis();
        }
    }

    class MySet {
        Map<String, Node> map = new HashMap<>();
        LinkedList<Node> list = new LinkedList<>();
        long expirationTime = 1000 * 60 * 60;
        int randomPartCount = 8;

        String get(String key) {
            if (!map.containsKey(key)) return null;
            Node node = map.get(key);
            if (node.shouldRemove(expirationTime)) {
                Node remove = map.remove(key);
                list.remove(remove);
                return null;
            }
            return node.value;
        }

        void add(String key, String value) {
            if (map.containsKey(key)) {
                list.remove(map.get(key));
            }
            Node node = new Node(key, value, System.currentTimeMillis());
            map.put(key, node);
            list.addLast(node);
        }

        void remove(String key) {
            if (!map.containsKey(key)) return;
            Node node = map.get(key);
            list.remove(node);
        }

        void checkValid() {
            while (!list.isEmpty() && list.peekFirst().shouldRemove(expirationTime)) {
                Node node = list.removeFirst();
                map.remove(node.key);
            }
        }

        void checkRandom() {

        }
    }
}

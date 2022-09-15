package company.amazon.ood2;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class SetWithExpiration {
    class Node {
        long timestamp;
        String key;
        String value;

        public Node(long timestamp, String key, String value) {
            this.timestamp = timestamp;
            this.key = key;
            this.value = value;
        }

        public boolean shouldRemove(long expiration_time) {
            return this.timestamp < System.currentTimeMillis() - expiration_time;
        }
    }

    class Cache {
        Map<String, Node> map = new HashMap<>();
        LinkedList<Node> queue = new LinkedList<>();
        public static final long EXPIRATION = 1000 * 60 * 60;

        void add(String key, String value) {
            Node node = new Node(System.currentTimeMillis(), key, value);
            if (map.containsKey(key)) {
                queue.remove(map.get(key));
                map.remove(key);
            }
            map.put(key, node);
            queue.addLast(node);
            checkTimeStamp();
        }

        String get(String key) {
            if (!map.containsKey(key)) return "";
            Node node = map.get(key);
            if (node.shouldRemove(EXPIRATION)) {
                map.remove(key);
                return "";
            }
            return node.value;
        }

        private void checkTimeStamp() {
            while (!queue.isEmpty() && queue.peekFirst().shouldRemove(EXPIRATION)) {
                Node node = queue.removeFirst();
                map.remove(node.key);
            }
        }
    }
}

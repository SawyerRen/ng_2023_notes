package company.amazon.q1100;

import java.util.HashMap;
import java.util.Map;

public class Q1166 {
    class Node {
        String name;
        int value = -1;
        Map<String, Node> map = new HashMap<>();

        public Node(String name) {
            this.name = name;
        }
    }

    class FileSystem {
        Node root = new Node("");

        public FileSystem() {

        }

        public boolean createPath(String path, int value) {
            String[] split = path.split("/");
            Node cur = root;
            for (int i = 1; i < split.length; i++) {
                if (i != split.length - 1) {
                    if (!cur.map.containsKey(split[i])) return false;
                } else {
                    if (cur.map.containsKey(split[i])) return false;
                    cur.map.put(split[i], new Node(split[i]));
                }
                cur = cur.map.get(split[i]);
            }
            cur.value = value;
            return true;
        }

        public int get(String path) {
            String[] split = path.split("/");
            Node cur = root;
            for (int i = 1; i < split.length; i++) {
                if (!cur.map.containsKey(split[i])) return -1;
                cur = cur.map.get(split[i]);
            }
            return cur.value;
        }
    }
}

package company.amazon.ood;

import java.util.*;

class Node {
    int key;
    int val;
    long expirationTimestamp;

    public Node(int key, int val, long expirationTimestamp) {
        this.key = key;
        this.val = val;
        this.expirationTimestamp = expirationTimestamp;
    }
}

public class SetWithExpiration {
    Map<Integer, Node> map = new HashMap<>();
    Queue<Node> queue = new LinkedList<>();

    Integer get(int key) {
        if (!map.containsKey(key)) return null;
        Node node = map.get(key);
        if (node.expirationTimestamp < System.currentTimeMillis()) {
            map.remove(key);
            return null;
        }
        return node.val;
    }

    boolean add(int key, int value, long timestamp) {
        checkValidTimestamp();
        if (map.containsKey(key)) return false;
        Node node = new Node(key, value, timestamp);
        map.put(key, node);
        queue.add(node);
        return true;
    }

    boolean remove(int key, long timestamp) {
        checkValidTimestamp();
        if (!map.containsKey(key)) return false;
        Node remove = map.remove(key);
        queue.remove(remove);
        return true;
    }

    void checkValidTimestamp() {
        while (!queue.isEmpty() && queue.peek().expirationTimestamp < System.currentTimeMillis()) {
            Node poll = queue.poll();
            map.remove(poll.key);
        }
    }
}

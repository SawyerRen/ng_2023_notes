package company.amazon.ood;

import java.util.*;

class Node {
    int val;
    long expirationTimestamp;

    public Node(int val, long expirationTimestamp) {
        this.val = val;
        this.expirationTimestamp = expirationTimestamp;
    }
}

public class SetWithExpiration {
    Map<Integer, Node> set = new HashMap<>();
    Queue<Node> queue = new LinkedList<>();

    boolean add(int value, long timestamp) {
        while (!queue.isEmpty() && queue.peek().expirationTimestamp < timestamp) {
            Node poll = queue.poll();
            set.remove(poll.val);
        }
        if (set.containsKey(value)) return false;
        Node node = new Node(value, timestamp);
        set.put(value, node);
        queue.add(node);
        return true;
    }

    boolean remove(int value, long timestamp) {
        while (!queue.isEmpty() && queue.peek().expirationTimestamp < timestamp) {
            Node poll = queue.poll();
            set.remove(poll.val);
        }
        if (!set.containsKey(value)) return false;
        for (Node node : queue) {
            if (node.val == value) {
                queue.remove(node);
                break;
            }
        }
        set.remove(value);
        return true;
    }
}

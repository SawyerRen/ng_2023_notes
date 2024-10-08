package company.bloomberg.goodluck;

import java.util.HashMap;
import java.util.Map;

public class Q138 {
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {
        if (head == null) return null;
        // map保存原节点和复制的节点
        Map<Node, Node> map = new HashMap<>();
        // 第一次遍历保存节点和对应的复制节点
        Node cur = head;
        while (cur != null) {
            map.put(cur, new Node(cur.val));
            cur = cur.next;
        }
        // 第二次遍历设置next和random节点
        cur = head;
        while (cur != null) {
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }
        return map.get(head);
    }
}

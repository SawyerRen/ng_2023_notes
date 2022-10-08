package company.bloomberg.vo;

import model.ListNode;

public class Q237 {
    public void deleteNode(ListNode node) {
        ListNode pre = node;
        while (node.next != null) {
            pre = node;
            node.val = node.next.val;
            node = node.next;
        }
        pre.next = null;
    }
}

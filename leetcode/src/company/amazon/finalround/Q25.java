package company.amazon.finalround;

import model.ListNode;

public class Q25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode pre = dummy;
        ListNode tail = dummy;
        while (true) {
            int temp = 0;
            while (tail != null && temp++ < k) {
                tail = tail.next;
            }
            if (tail == null) break;
            ListNode nextDummy = pre.next;
            while (pre.next != tail) {
                ListNode node = pre.next;
                pre.next = node.next;
                node.next = tail.next;
                tail.next = node;
            }
            pre = nextDummy;
            tail = nextDummy;
        }
        return dummy.next;
    }
}

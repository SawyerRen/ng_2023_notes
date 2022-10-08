package company.bloomberg.vo;

import model.ListNode;

public class Q25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode pre = dummy, tail = dummy;
        while (true) {
            int temp = k;
            while (tail != null && temp-- > 0) {
                tail = tail.next;
            }
            if (tail == null) break;
            ListNode nextDummy = pre.next;
            while (pre.next != tail) {
                ListNode next = pre.next;
                pre.next = next.next;
                next.next = tail.next;
                tail.next = next;
            }
            pre = nextDummy;
            tail = nextDummy;
        }
        return dummy.next;
    }
}

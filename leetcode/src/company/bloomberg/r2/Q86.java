package company.bloomberg.r2;

import model.ListNode;

public class Q86 {
    public ListNode partition(ListNode head, int x) {
        ListNode largeHead = new ListNode(), smallHead = new ListNode();
        ListNode large = largeHead, small = smallHead;
        while (head != null) {
            ListNode next = head.next;
            head.next = null;
            if (head.val < x) {
                small.next = head;
                small = small.next;
            } else {
                large.next = head;
                large = large.next;
            }
            head = next;
        }
        small.next = largeHead.next;
        return smallHead.next;
    }
}

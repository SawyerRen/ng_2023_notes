package company.bloomberg.vo;

import model.ListNode;

public class Q86 {
    public ListNode partition(ListNode head, int x) {
        ListNode largeHead = new ListNode(), smallHead = new ListNode();
        ListNode large = largeHead, small = smallHead;
        while (head != null) {
            if (head.val < x) {
                small.next = head;
                small = small.next;
            } else {
                large.next = head;
                large = large.next;
            }
            ListNode next = head.next;
            head.next = null;
            head = next;
        }
        small.next = largeHead.next;
        return smallHead.next;
    }
}

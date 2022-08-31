package company.bloomberg.q0;

import model.ListNode;

import java.util.List;

public class Q86 {
    public ListNode partition(ListNode head, int x) {
        ListNode largeHead = new ListNode();
        ListNode large = largeHead;
        ListNode smallHead = new ListNode();
        ListNode small = smallHead;
        while (head != null) {
            ListNode next = head.next;
            head.next = null;
            if (head.val >= x) {
                large.next = head;
                large = large.next;
            } else {
                small.next = head;
                small = small.next;
            }
            head = next;
        }
        small.next = largeHead.next;
        return smallHead.next;
    }
}

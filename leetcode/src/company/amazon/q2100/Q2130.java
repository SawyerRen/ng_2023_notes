package company.amazon.q2100;

import model.ListNode;

import java.util.List;

public class Q2130 {
    public int pairSum(ListNode head) {
        if (head == null) return 0;
        ListNode fast = head, slow = head, pre = slow;
        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        pre.next = null;
        ListNode head2 = reverse(slow);
        int res = Integer.MIN_VALUE;
        while (head != null) {
            res = Math.max(res, head.val + head2.val);
            head = head.next;
            head2 = head2.next;
        }
        return res;
    }

    private ListNode reverse(ListNode head) {
        ListNode dummy = new ListNode();
        while (head != null) {
            ListNode next = head.next;
            head.next = dummy.next;
            dummy.next = head;
            head = next;
        }
        return dummy.next;
    }
}

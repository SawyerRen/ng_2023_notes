package company.amazon.q2100;

import model.ListNode;

public class Q2130 {
    public int pairSum(ListNode head) {
        ListNode fast = head, slow = head, pre = head;
        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        pre.next = null;
        ListNode head2 = reverse(slow);
        int res = head.val + head2.val;
        while (head != null && head2 != null) {
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

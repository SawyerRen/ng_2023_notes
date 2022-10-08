package company.bloomberg.vo;

import model.ListNode;

public class Q141 {
    public boolean hasCycle(ListNode head) {
        if (head == null) return false;
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) return true;
        }
        return false;
    }
}

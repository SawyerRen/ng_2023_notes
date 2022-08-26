package company.amazon.q0;

import model.ListNode;

public class Q23 {
    public ListNode mergeKLists(ListNode[] lists) {
        return sort(lists, 0, lists.length - 1);
    }

    private ListNode sort(ListNode[] lists, int left, int right) {
        if (left > right) return null;
        if (left == right) return lists[left];
        int mid = left + (right - left) / 2;
        ListNode l1 = sort(lists, left, mid);
        ListNode l2 = sort(lists, mid + 1, right);
        return merge(l1, l2);
    }

    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        if (l1 != null) cur.next = l1;
        else if (l2 != null) cur.next = l2;
        return dummy.next;
    }
}

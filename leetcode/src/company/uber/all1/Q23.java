package company.uber.all1;

import model.ListNode;

import java.util.PriorityQueue;

public class Q23 {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        for (ListNode list : lists) {
            if (list != null) pq.add(list);
        }
        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        while (!pq.isEmpty()) {
            ListNode poll = pq.poll();
            cur.next = poll;
            cur = cur.next;
            if (poll.next != null) pq.add(poll.next);
        }
        return dummy.next;
    }
}

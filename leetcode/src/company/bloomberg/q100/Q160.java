package company.bloomberg.q100;

import com.sun.org.apache.bcel.internal.generic.LNEG;
import model.ListNode;

import java.util.List;

public class Q160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode a = headA, b = headB;
        while (a != b) {
            a = a == null ? headB : a.next;
            b = b == null ? headA : b.next;
        }
        return a;
    }
}

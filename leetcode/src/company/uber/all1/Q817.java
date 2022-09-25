package company.uber.all1;

import model.ListNode;

import java.util.HashSet;
import java.util.Set;

public class Q817 {
    public int numComponents(ListNode head, int[] nums) {
        int count = 0;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        while (head != null) {
            if (set.contains(head.val)) {
                count++;
                ListNode cur = head;
                while (cur.next != null && set.contains(cur.next.val)) {
                    cur = cur.next;
                }
                head = cur.next;
            } else {
                head = head.next;
            }
        }
        return count;
    }
}

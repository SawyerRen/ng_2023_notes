package company.uber.q800;

import model.ListNode;

import java.util.HashSet;
import java.util.Set;

public class Q817 {
    public int numComponents(ListNode head, int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int res = 0;
        while (head != null) {
            ListNode cur = head;
            if (set.contains(cur.val)) {
                res++;
                while (cur.next != null && set.contains(cur.next.val)) {
                    cur = cur.next;
                }
            }
            head = cur.next;
        }
        return res;
    }
}

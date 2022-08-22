package company.bloomberg.q400;

import model.ListNode;

import java.util.Stack;

public class Q445 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        while (l1 != null) {
            stack1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }
        ListNode res = null;
        int carry = 0;
        while (!stack1.isEmpty() || !stack2.isEmpty() || carry != 0) {
            int v1 = stack1.isEmpty() ? 0 : stack1.pop();
            int v2 = stack2.isEmpty() ? 0 : stack2.pop();
            int sum = v1 + v2 + carry;
            res = new ListNode(sum % 10, res);
            carry = sum / 10;
        }
        return res;
    }
}

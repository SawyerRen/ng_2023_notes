package company.uber.all1;

import java.util.LinkedList;

public class Q67 {
    public String addBinary(String a, String b) {
        int i = a.length() - 1, j = b.length() - 1;
        LinkedList<Integer> list = new LinkedList<>();
        int carry = 0;
        while (i >= 0 || j >= 0 || carry != 0) {
            int n1 = i >= 0 ? a.charAt(i) - '0' : 0;
            int n2 = j >= 0 ? b.charAt(j) - '0' : 0;
            int sum = n1 + n2 + carry;
            carry = sum / 2;
            list.addFirst(sum % 2);
            i--;
            j--;
        }
        StringBuilder builder = new StringBuilder();
        for (Integer v : list) {
            builder.append(v);
        }
        return builder.toString();
    }
}

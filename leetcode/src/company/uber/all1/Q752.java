package company.uber.all1;

import com.sun.tools.javah.LLNI;

import java.util.*;

public class Q752 {
    public int openLock(String[] deadends, String target) {
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>(Arrays.asList(deadends));
        if (visited.contains("0000") || visited.contains(target)) return -1;
        queue.add("0000");
        visited.add("0000");
        int res = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String poll = queue.poll();
                if (poll.equals(target)) return res;
                List<String> nextList = getNext(poll);
                for (String s : nextList) {
                    if (visited.contains(s)) continue;
                    queue.add(s);
                    visited.add(s);
                }
            }
            res++;
        }
        return -1;
    }

    private List<String> getNext(String s) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            char[] chars = s.toCharArray();
            int n = chars[i] - '0';
            int n1 = n == 0 ? 9 : n - 1;
            int n2 = n == 9 ? 0 : n + 1;
            chars[i] = (char) ('0' + n1);
            list.add(new String(chars));
            chars[i] = (char) ('0' + n2);
            list.add(new String(chars));
        }
        return list;
    }
}

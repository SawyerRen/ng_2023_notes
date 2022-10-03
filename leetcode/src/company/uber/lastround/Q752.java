package company.uber.lastround;

import java.util.*;

public class Q752 {
    public int openLock(String[] deadends, String target) {
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>(Arrays.asList(deadends));
        if (visited.contains("0000")) return -1;
        queue.add("0000");
        visited.add("0000");
        int res = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String poll = queue.poll();
                if (poll.equals(target)) return res;
                List<String> nextList = helper(poll);
                for (String next : nextList) {
                    if (visited.contains(next)) continue;
                    queue.add(next);
                    visited.add(next);
                }
            }
            res++;
        }
        return -1;
    }

    private List<String> helper(String s) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            char[] chars = s.toCharArray();
            int num = chars[i] - '0';
            int n1 = num == 9 ? 0 : num + 1;
            int n2 = num == 0 ? 9 : num - 1;
            chars[i] = (char) (n1 + '0');
            list.add(new String(chars));
            chars[i] = (char) (n2 + '0');
            list.add(new String(chars));
        }
        return list;
    }
}

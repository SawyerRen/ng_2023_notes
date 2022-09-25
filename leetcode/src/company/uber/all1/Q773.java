package company.uber.all1;

import java.util.*;

public class Q773 {
    int[][] arr = {{1, 3}, {0, 2, 4}, {1, 5}, {0, 4}, {1, 3, 5}, {2, 4}};

    public int slidingPuzzle(int[][] board) {
        String start = "";
        for (int[] ints : board) {
            for (int anInt : ints) {
                start += anInt;
            }
        }
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.add(start);
        visited.add(start);
        int res = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String poll = queue.poll();
                if (poll.equals("123450")) return res;
                List<String> nextList = getNext(poll);
                for (String s : nextList) {
                    if (visited.contains(s)) continue;
                    visited.add(s);
                    queue.add(s);
                }
            }
            res++;
        }
        return -1;
    }

    private List<String> getNext(String s) {
        int index = s.indexOf('0');
        List<String> res = new ArrayList<>();
        for (int i : arr[index]) {
            StringBuilder builder = new StringBuilder(s);
            builder.setCharAt(index, s.charAt(i));
            builder.setCharAt(i, '0');
            res.add(builder.toString());
        }
        return res;
    }
}

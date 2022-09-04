package company.bloomberg.q1500;

import javafx.util.Pair;

import java.util.*;

public class Q1553 {
    Map<Integer, Integer> memo = new HashMap<>();

    public int minDays(int n) {
        if (n <= 1) return n;
        if (memo.containsKey(n)) return memo.get(n);
        int res = Math.min(n % 2 + minDays(n / 2), n % 3 + minDays(n / 3)) + 1;
        memo.put(n, res);
        return res;
    }

    public int minDays1(int n) {
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        queue.add(n);
        visited.add(n);
        int res = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Integer poll = queue.poll();
                if (poll.equals(0)) return res;
                if (!visited.contains(poll - 1)) {
                    queue.add(poll - 1);
                    visited.add(poll - 1);
                }
                if (poll % 2 == 0 && !visited.contains(poll / 2)) {
                    queue.add(poll / 2);
                    visited.add(poll / 2);
                }
                if (poll % 3 == 0 && !visited.contains(poll / 3)) {
                    queue.add(poll / 3);
                    visited.add(poll / 3);
                }
            }
            res++;
        }
        return -1;
    }

    static public List<Integer> minDaysWithPrint(int n) {
        Queue<Pair<Integer, List<Integer>>> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        list.add(n);
        queue.add(new Pair<>(n, list));
        visited.add(n);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Pair<Integer, List<Integer>> poll = queue.poll();
                Integer num = poll.getKey();
                List<Integer> value = poll.getValue();
                if (num.equals(0)) return value;
                if (!visited.contains(num - 1)) {
                    List<Integer> newValues = new ArrayList<>(value);
                    newValues.add(num - 1);
                    queue.add(new Pair<>(num - 1, newValues));
                    visited.add(num - 1);
                }
                if (num % 2 == 0 && !visited.contains(num / 2)) {
                    List<Integer> newValues = new ArrayList<>(value);
                    newValues.add(num / 2);
                    queue.add(new Pair<>(num / 2, newValues));
                    visited.add(num / 2);
                }
                if (num % 3 == 0 && !visited.contains(num / 3)) {
                    List<Integer> newValues = new ArrayList<>(value);
                    newValues.add(num / 3);
                    queue.add(new Pair<>(num / 3, newValues));
                    visited.add(num / 3);
                }
            }
        }
        return new ArrayList<>();
    }

    public static void main(String[] args) {
        System.out.println(minDaysWithPrint(10));
    }
}

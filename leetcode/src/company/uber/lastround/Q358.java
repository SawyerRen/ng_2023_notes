package company.uber.lastround;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Q358 {
    public String rearrangeString(String s, int k) {
        if (k == 0) return s;
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        PriorityQueue<Character> pq = new PriorityQueue<>((a, b) -> count[b - 'a'] - count[a - 'a']);
        for (int i = 0; i < 26; i++) {
            if (count[i] > 0)
                pq.add((char) (i + 'a'));
        }
        StringBuilder builder = new StringBuilder();
        Queue<Character> wait = new LinkedList<>();
        while (!pq.isEmpty()) {
            Character c = pq.poll();
            builder.append(c);
            count[c - 'a']--;
            wait.add(c);
            if (wait.size() < k) continue;
            Character poll = wait.poll();
            if (count[poll - 'a'] > 0) pq.add(poll);
        }
        if (builder.length() == s.length()) return builder.toString();
        return "";
    }
}

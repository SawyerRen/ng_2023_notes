package company.uber.lastround;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Q358 {
    public String rearrangeString(String s, int k) {
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        PriorityQueue<Character> pq = new PriorityQueue<>((a, b) -> count[b - 'a'] - count[a - 'a']);
        for (int i = 0; i < 26; i++) {
            if (count[i] > 0) {
                pq.add((char) (i + 'a'));
            }
        }
        Queue<Character> wait = new LinkedList<>();
        StringBuilder builder = new StringBuilder();
        while (!pq.isEmpty()) {
            Character c = pq.poll();
            builder.append(c);
            wait.add(c);
            count[c - 'a']--;
            if (wait.size() < k) continue;
            Character poll = wait.poll();
            if (count[poll - 'a'] > 0) pq.add(poll);
        }
        if (builder.length() < s.length()) return "";
        return builder.toString();
    }
}

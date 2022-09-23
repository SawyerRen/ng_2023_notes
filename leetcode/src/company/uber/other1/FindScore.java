package company.uber.other1;

import java.util.PriorityQueue;

public class FindScore {
    int[] findScore(int[] scores, int k, int start) {
        PriorityQueue<Integer> pqA = new PriorityQueue<>((a, b) -> b - a);
        PriorityQueue<Integer> pqB = new PriorityQueue<>((a, b) -> {
            int n1 = 0, n2 = 0;
            while (a != 0) {
                n1 += a % 10;
                a /= 10;
            }
            while (b != 0) {
                n2 += b % 10;
                b /= 10;
            }
            return n2 - n1;
        });
        for (int score : scores) {
            pqA.add(score);
            pqB.add(score);
        }
        int scoreA = 0, scoreB = 0;
        while (!pqA.isEmpty()) {
            int temp = k;
            while (temp-- > 0 && pqA.size() > 0) {
                if (start == 1) {
                    Integer poll = pqA.poll();
                    scoreA += poll;
                    pqB.remove(poll);
                } else {
                    Integer poll = pqB.poll();
                    scoreB += poll;
                    pqA.remove(poll);
                }
            }
        }
        return new int[]{scoreA, scoreB};
    }
}

package company.uber.lastround;

import java.util.PriorityQueue;

public class FindScore {
    int[] solution(int[] arr, int k, char player) {
        PriorityQueue<Integer> pqA = new PriorityQueue<>((a, b) -> b - a);
        PriorityQueue<Integer> pqB = new PriorityQueue<>((a, b) -> {
            int t1 = a, t2 = b;
            int sum1 = 0, sum2 = 0;
            while (t1 != 0) {
                sum1 += t1 % 10;
                t1 /= 10;
            }
            while (t2 != 0) {
                sum2 += t2 % 10;
                t2 /= 10;
            }
            return sum1 == sum2 ? b - a : sum2 - sum1;
        });
        for (int i : arr) {
            pqA.add(i);
            pqB.add(i);
        }
        int scoreA = 0, scoreB = 0;
        while (!pqA.isEmpty()) {
            int temp = k;
            if (player == 'A') {
                while (!pqA.isEmpty() && temp-- > 0) {
                    Integer poll = pqA.poll();
                    pqB.remove(poll);
                    scoreA += poll;
                }
            } else {
                while (!pqB.isEmpty() && temp-- > 0) {
                    Integer poll = pqB.poll();
                    pqA.remove(poll);
                    scoreB += poll;
                }
            }
            player = player == 'A' ? 'B' : 'A';
        }
        return new int[]{scoreA, scoreB};
    }
}

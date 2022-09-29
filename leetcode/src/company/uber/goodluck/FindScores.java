package company.uber.goodluck;

import java.util.PriorityQueue;

public class FindScores {
    static int[] solution(int[] scores, int k, char start) {
        PriorityQueue<Integer> pqA = new PriorityQueue<>((a, b) -> b - a);
        PriorityQueue<Integer> pqB = new PriorityQueue<>((a, b) -> {
            int temp1 = a, temp2 = b;
            int sum1 = 0, sum2 = 0;
            while (temp1 != 0) {
                sum1 += temp1 % 10;
                temp1 /= 10;
            }
            while (temp2 != 0) {
                sum2 += temp2 % 10;
                temp2 /= 10;
            }
            return sum1 == sum2 ? b - a : sum2 - sum1;
        });
        int scoreA = 0, scoreB = 0;
        for (int score : scores) {
            pqA.add(score);
            pqB.add(score);
        }
        while (!pqA.isEmpty()) {
            int temp = k;
            if (start == 'A') {
                while (!pqA.isEmpty() && temp-- > 0) {
                    Integer poll = pqA.poll();
                    scoreA += poll;
                    pqB.remove(poll);
                }
            } else {
                while (!pqB.isEmpty() && temp-- > 0) {
                    Integer poll = pqB.poll();
                    scoreB += poll;
                    pqA.remove(poll);
                }
            }
            start = start == 'A' ? 'B' : 'A';
        }
        return new int[]{scoreA, scoreB};
    }

    public static void main(String[] args) {
        int[] scores = {11,11,11};
        int[] as = solution(scores, 2, 'B');
        for (int a : as) {
            System.out.println(a);
        }
    }
}

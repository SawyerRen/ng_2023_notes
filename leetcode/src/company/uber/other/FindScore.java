package company.uber.other;

import java.util.PriorityQueue;

/**
 * 所有球的score给出来。A和B玩一个游戏，可能A先挑球，可能B先挑。A会优先挑score大的，B会优先挑digit的和大的，
 * 如果和相等再挑score大的。每一轮挑k个，输出最后A和B的分数。
 */
public class FindScore {
    int[] findScore(int[] scores, int k, int start) {
        int count = scores.length;
        PriorityQueue<Integer> pqA = new PriorityQueue<>((a, b) -> b - a);
        PriorityQueue<Integer> pqB = new PriorityQueue<>((a, b) -> {
            int sumA = 0, sumB = 0;
            int tempA = a, tempB = b;
            while (tempA != 0) {
                sumA += tempA % 10;
                tempA /= 10;
            }
            while (tempB != 0) {
                sumB += tempB % 10;
                tempB /= 10;
            }
            if (sumA == sumB) return b - a;
            return sumB - sumA;
        });
        if (start == 0) {
            for (int score : scores) {
                pqA.add(score);
            }
        } else {
            for (int score : scores) {
                pqB.add(score);
            }
        }
        int scoreA = 0, scoreB = 0;
        while (!pqA.isEmpty() || !pqB.isEmpty()) {
            int temp = 0;
            if (pqA.size() > 0) {
                while (pqA.size() > 0 && temp < k) {
                    scoreA += pqA.poll();
                    temp++;
                }
                pqB.addAll(pqA);
                pqA.clear();
            } else {
                while (pqB.size() > 0 && temp < k) {
                    scoreB += pqB.poll();
                    temp++;
                }
                pqA.addAll(pqB);
                pqB.clear();
            }
        }
        return new int[]{scoreA, scoreB};
    }
}

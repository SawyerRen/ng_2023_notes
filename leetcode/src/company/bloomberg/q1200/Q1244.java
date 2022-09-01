package company.bloomberg.q1200;

import java.util.*;

public class Q1244 {
    class Leaderboard {
        TreeMap<Integer, Integer> scoreCount = new TreeMap<>(Comparator.reverseOrder());
        HashMap<Integer, Integer> playerScore = new HashMap<>();

        public Leaderboard() {

        }

        public void addScore(int playerId, int score) {
            int oldScore = playerScore.getOrDefault(playerId, 0);
            if (oldScore != 0) scoreCount.put(oldScore, scoreCount.get(oldScore) - 1);
            int newScore = oldScore + score;
            playerScore.put(playerId, newScore);
            scoreCount.put(newScore, scoreCount.getOrDefault(newScore, 0) + 1);
        }

        public int top(int K) {
            int sum = 0;
            for (Integer score : scoreCount.keySet()) {
                if (K == 0) break;
                int count = scoreCount.get(score);
                if (K >= count) {
                    sum += score * count;
                    K -= count;
                } else {
                    sum += score * K;
                    K = 0;
                }
            }
            return sum;
        }

        public void reset(int playerId) {
            Integer score = playerScore.remove(playerId);
            scoreCount.put(score, scoreCount.get(score) - 1);
        }
    }

}

package company.bloomberg.q1200;

import java.util.*;

public class Q1244 {
    class Leaderboard {
        Map<Integer, Integer> playerScoreMap = new HashMap<>();
        TreeMap<Integer, Integer> scoreCountMap = new TreeMap<>(Comparator.reverseOrder());

        public Leaderboard() {

        }

        public void addScore(int playerId, int score) {
            int oldScore = playerScoreMap.getOrDefault(playerId, 0);
            int newScore = oldScore + score;
            playerScoreMap.put(playerId, newScore);
            if (scoreCountMap.containsKey(oldScore)) {
                scoreCountMap.put(oldScore, scoreCountMap.get(oldScore) - 1);
            }
            scoreCountMap.put(newScore, scoreCountMap.getOrDefault(newScore, 0) + 1);
        }

        public int top(int K) {
            int res = 0;
            for (Integer score : scoreCountMap.keySet()) {
                int count = scoreCountMap.get(score);
                if (K >= count) {
                    res += score * count;
                    K -= count;
                } else {
                    res += score * K;
                    K = 0;
                }
                if (K == 0) break;
            }
            return res;
        }

        public void reset(int playerId) {
            Integer score = playerScoreMap.get(playerId);
            playerScoreMap.remove(playerId);
            scoreCountMap.put(score, scoreCountMap.get(score) - 1);
        }
    }
}

package company.bloomberg.q1200;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Q1244 {
    class Leaderboard {
        Map<Integer, Integer> playerScoreMap = new HashMap<>();
        TreeMap<Integer, Integer> scoreCountMap = new TreeMap<>(Comparator.reverseOrder());

        public Leaderboard() {

        }

        public void addScore(int playerId, int score) {
            Integer oldScore = playerScoreMap.get(playerId);
            if (oldScore != null) {
                scoreCountMap.put(oldScore, scoreCountMap.get(oldScore) - 1);
            }
            int newScore = oldScore == null ? score : oldScore + score;
            playerScoreMap.put(playerId, newScore);
            scoreCountMap.put(newScore, scoreCountMap.getOrDefault(newScore, 0) + 1);
        }

        public int top(int K) {
            int res = 0;
            for (Integer score : scoreCountMap.keySet()) {
                if (K <= 0) break;
                for (int i = 0; i < scoreCountMap.get(score) && K > 0; i++) {
                    res += score;
                    K--;
                }
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

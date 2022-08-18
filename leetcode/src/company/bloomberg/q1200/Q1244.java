package company.bloomberg.q1200;

import java.util.*;

public class Q1244 {
    class Leaderboard {
        TreeMap<Integer, Integer> scoreMap = new TreeMap<>(Collections.reverseOrder());
        HashMap<Integer, Integer> playerMap = new HashMap<>();

        public Leaderboard() {

        }

        public void addScore(int playerId, int score) {
            int oldScore = playerMap.getOrDefault(playerId, 0);
            int newScore = oldScore + score;
            if (oldScore > 0) scoreMap.put(oldScore, scoreMap.get(oldScore) - 1);
            playerMap.put(playerId, newScore);
            scoreMap.put(newScore, scoreMap.getOrDefault(newScore, 0) + 1);
        }

        public int top(int K) {
            int sum = 0;
            for (Integer score : scoreMap.keySet()) {
                for (int i = 0; i < scoreMap.get(score); i++) {
                    sum += score;
                    K--;
                    if (K == 0) return sum;
                }
            }
            return sum;
        }

        public void reset(int playerId) {
            Integer score = playerMap.remove(playerId);
            scoreMap.put(score, scoreMap.get(score) - 1);
        }
    }
}

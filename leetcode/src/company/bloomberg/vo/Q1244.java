package company.bloomberg.vo;

import java.util.*;

public class Q1244 {
    class Leaderboard {
        TreeMap<Integer, Integer> scoreCountMap = new TreeMap<>(Comparator.reverseOrder());
        Map<Integer, Integer> playerScoreMap = new HashMap<>();

        public Leaderboard() {

        }

        public void addScore(int playerId, int score) {
            Integer oldScore = playerScoreMap.get(playerId);
            if (oldScore != null) {
                score += oldScore;
                scoreCountMap.put(oldScore, scoreCountMap.get(oldScore) - 1);
            }
            playerScoreMap.put(playerId, score);
            scoreCountMap.put(score, scoreCountMap.getOrDefault(score, 0) + 1);
        }

        public int top(int k) {
            int res = 0;
            for (Integer score : scoreCountMap.keySet()) {
                Integer count = scoreCountMap.get(score);
                if (count > k) {
                    res += score * k;
                    k = 0;
                } else {
                    res += score * count;
                    k -= count;
                }
                if (k == 0) break;
            }
            return res;
        }

        public void reset(int playerId) {
            Integer score = playerScoreMap.remove(playerId);
            scoreCountMap.put(score, scoreCountMap.get(score) - 1);
        }
    }

    class Leaderboard1 {
        Map<Integer, Integer> map = new HashMap<>();

        public Leaderboard1() {

        }

        public void addScore(int playerId, int score) {
            map.put(playerId, map.getOrDefault(playerId, 0) + score);
        }

        public int top(int k) {
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            for (Integer id : map.values()) {
                pq.add(id);
                if (pq.size() > k) pq.poll();
            }
            int res = 0;
            for (Integer score : pq) {
                res += score;
            }
            return res;
        }

        public void reset(int playerId) {
            map.remove(playerId);
        }
    }
}

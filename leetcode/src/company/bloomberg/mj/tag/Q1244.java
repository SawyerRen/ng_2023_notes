package company.bloomberg.mj.tag;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Q1244 {
    class Leaderboard {
        Map<Integer, Integer> map = new HashMap<>();
        TreeMap<Integer, Integer> treeMap = new TreeMap<>(Comparator.reverseOrder());

        public Leaderboard() {

        }

        public void addScore(int playerId, int score) {
            int oldScore = map.getOrDefault(playerId, 0);
            if (oldScore != 0) {
                treeMap.put(oldScore, treeMap.get(oldScore) - 1);
            }
            score += oldScore;
            map.put(playerId, score);
            treeMap.put(score, treeMap.getOrDefault(score, 0) + 1);
        }

        public int top(int k) {
            int res = 0;
            for (Integer score : treeMap.keySet()) {
                Integer count = treeMap.get(score);
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
            int score = map.remove(playerId);
            treeMap.put(score, treeMap.get(score) - 1);
        }
    }
}

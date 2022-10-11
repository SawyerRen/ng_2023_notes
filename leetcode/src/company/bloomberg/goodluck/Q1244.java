package company.bloomberg.goodluck;

import java.util.*;

public class Q1244 {
    private class Leaderboard {
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
                int count = treeMap.get(score);
                if (count >= k) {
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
            Integer score = map.remove(playerId);
            treeMap.put(score, treeMap.get(score) - 1);
        }
    }

    private class StockSystem {
        Map<String, Integer> map = new HashMap<>();

        void addStockVolume(String stock, int volume) {
            map.put(stock, map.getOrDefault(stock, 0) + volume);
        }

        List<String> topK(int k) {
            PriorityQueue<String> pq = new PriorityQueue<>((a, b) -> map.get(b) - map.get(a));
            for (String stock : map.keySet()) {
                pq.add(stock);
                if (pq.size() > k) pq.poll();
            }
            return new ArrayList<>(pq);
        }
    }

    private class StockSystem2 {
        Map<String, Integer> map = new HashMap<>();
        TreeMap<Integer, Set<String>> treeMap = new TreeMap<>(Comparator.reverseOrder());

        void addStockVolume(String stock, int volume) {
            Integer oldVal = map.get(stock);
            if (oldVal != null) {
                treeMap.get(oldVal).remove(stock);
                volume += oldVal;
            }
            map.put(stock, volume);
            treeMap.putIfAbsent(volume, new HashSet<>());
            treeMap.get(volume).add(stock);
        }

        List<String> topK(int k) {
            List<String> res = new ArrayList<>();
            for (Integer volume : treeMap.keySet()) {
                Set<String> set = treeMap.get(volume);
                for (String s : set) {
                    res.add(s);
                    k--;
                    if (k == 0) break;
                }
                if (k == 0) break;
            }
            return res;
        }
    }
}

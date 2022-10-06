package company.bloomberg.all.q1200;

import java.util.*;

public class Q1244 {
    class Leaderboard {
        Map<Integer, Integer> map = new HashMap<>();
        TreeMap<Integer, Integer> treeMap = new TreeMap<>(Comparator.reverseOrder());

        public Leaderboard() {

        }

        public void addScore(int playerId, int score) {
            int oldScore = map.getOrDefault(playerId, 0);
            if (oldScore != 0) treeMap.put(oldScore, treeMap.get(oldScore) - 1);
            int newScore = score + oldScore;
            map.put(playerId, newScore);
            treeMap.put(newScore, treeMap.getOrDefault(newScore, 0) + 1);
        }

        public int top(int k) {
            int res = 0;
            for (Integer score : treeMap.keySet()) {
                Integer count = treeMap.get(score);
                if (k >= count) {
                    res += count * score;
                    k -= count;
                } else {
                    res += k * score;
                    k = 0;
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

    class StockSystem {
        Map<String, Integer> map = new HashMap<>();

        void addStock(String stock, int volume) {
            map.put(stock, map.getOrDefault(stock, 0) + volume);
        }

        List<String> topK(int k) {
            PriorityQueue<String> pq = new PriorityQueue<>((a, b) -> map.get(a) - map.get(b));
            for (String stock : map.keySet()) {
                pq.add(stock);
                if (pq.size() > k) pq.poll();
            }
            return new ArrayList<>(pq);
        }

    }

    class StockSystem1 {
        Map<String, Integer> stockMap = new HashMap<>();
        TreeMap<Integer, LinkedList<String>> priceMap = new TreeMap<>(Comparator.reverseOrder());

        void addStock(String stock, int volume) {
            int oldVolume = stockMap.getOrDefault(stock, 0);
            if (oldVolume != 0) priceMap.get(oldVolume).remove(stock);
            int newVolume = volume + oldVolume;
            stockMap.put(stock, newVolume);
            priceMap.putIfAbsent(newVolume, new LinkedList<>());
            priceMap.get(newVolume).addLast(stock);
        }

        List<String> topK(int k) {
            List<String> res = new ArrayList<>();
            for (Integer price : priceMap.keySet()) {
                if (k == 0) break;
                LinkedList<String> stockList = priceMap.get(price);
                for (String stock : stockList) {
                    if (k == 0) break;
                    res.add(stock);
                    k--;
                }
            }
            return res;
        }
    }
}

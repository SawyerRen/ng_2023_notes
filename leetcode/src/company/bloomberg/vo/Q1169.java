package company.bloomberg.vo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q1169 {
    class Node {
        int time;
        int amount;
        String city;

        public Node(int time, int amount, String city) {
            this.time = time;
            this.amount = amount;
            this.city = city;
        }
    }

    public List<String> invalidTransactions(String[] transactions) {
        Map<String, List<Node>> map = new HashMap<>();
        for (String t : transactions) {
            String[] split = t.split(",");
            map.putIfAbsent(split[0], new ArrayList<>());
            map.get(split[0]).add(new Node(Integer.parseInt(split[1]), Integer.parseInt(split[2]), split[3]));
        }
        List<String> list = new ArrayList<>();
        for (String name : map.keySet()) {
            List<Node> nodes = map.get(name);
            for (Node node : nodes) {
                if (node.amount > 1000) {
                    list.add(name + "," + node.time + "," + node.amount + "," + node.city);
                    continue;
                }
                for (Node node2 : nodes) {
                    if (Math.abs(node.time - node2.time) <= 60 && !node.city.equals(node2.city)) {
                        list.add(name + "," + node.time + "," + node.amount + "," + node.city);
                        break;
                    }
                }
            }
        }
        return list;
    }
}

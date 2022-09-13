package company.amazon.q1400;

import java.util.*;

public class Q1429 {
    class Node {
        int val;

        public Node(int val) {
            this.val = val;
        }
    }

    class FirstUnique {
        LinkedList<Node> list = new LinkedList<>();
        Map<Integer, Node> uniqueMap = new HashMap<>();
        Set<Integer> duplicateSet = new HashSet<>();

        public FirstUnique(int[] nums) {
            for (int num : nums) {
                add(num);
            }
        }

        public int showFirstUnique() {
            if (list.isEmpty()) return -1;
            return list.getFirst().val;
        }

        public void add(int value) {
            if (duplicateSet.contains(value)) return;
            if (uniqueMap.containsKey(value)) {
                list.remove(uniqueMap.get(value));
                uniqueMap.remove(value);
                duplicateSet.add(value);
            } else {
                Node node = new Node(value);
                list.addLast(node);
                uniqueMap.put(value, node);
            }
        }
    }
}

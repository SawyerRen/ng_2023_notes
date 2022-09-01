package company.bloomberg.q1500;

import java.util.ArrayList;
import java.util.List;

public class Q1570 {
    class Node {
        int index;
        int val;

        public Node(int index, int val) {
            this.index = index;
            this.val = val;
        }
    }

    class SparseVector {
        List<Node> list = new ArrayList<>();

        SparseVector(int[] nums) {
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != 0) list.add(new Node(i, nums[i]));
            }
        }

        // Return the dotProduct of two sparse vectors
        public int dotProduct(SparseVector vec) {
            int res = 0, i = 0, j = 0;
            List<Node> list2 = vec.list;
            while (i < list.size() && j < list2.size()) {
                Node node1 = list.get(i);
                Node node2 = list2.get(j);
                if (node1.index == node2.index) {
                    res += node1.val * node2.val;
                    i++;
                    j++;
                } else if (node1.index < node2.index) {
                    i++;
                } else {
                    j++;
                }
            }
            return res;
        }
    }
}

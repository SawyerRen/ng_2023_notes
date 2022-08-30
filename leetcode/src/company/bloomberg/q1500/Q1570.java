package company.bloomberg.q1500;

import java.util.ArrayList;
import java.util.List;

public class Q1570 {
    class Node {
        int index;
        int value;

        public Node(int index, int value) {
            this.index = index;
            this.value = value;
        }
    }

    class SparseVector {
        List<Node> nodes = new ArrayList<>();

        SparseVector(int[] nums) {
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != 0) {
                    nodes.add(new Node(i, nums[i]));
                }
            }
        }

        // Return the dotProduct of two sparse vectors
        public int dotProduct(SparseVector vec) {
            List<Node> nodes2 = vec.nodes;
            int i = 0, j = 0;
            int res = 0;
            while (i < nodes.size() && j < nodes2.size()) {
                if (nodes.get(i).index == nodes2.get(j).index) {
                    res += nodes.get(i).value * nodes2.get(j).value;
                    i++;
                    j++;
                } else if (nodes.get(i).index < nodes2.get(j).index) {
                    i++;
                } else {
                    j++;
                }
            }
            return res;
        }
    }
}

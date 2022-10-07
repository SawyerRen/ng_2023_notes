package company.bloomberg.vo;

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
        List<Node> list = new ArrayList<>();

        SparseVector(int[] nums) {
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != 0) list.add(new Node(i, nums[i]));
            }
        }

        // Return the dotProduct of two sparse vectors
        public int dotProduct(SparseVector vec) {
            List<Node> list2 = vec.list;
            int i = 0, j = 0;
            int res = 0;
            while (i < list.size() && j < list2.size()) {
                if (list.get(i).index == list2.get(j).index) {
                    res += list.get(i).value * list2.get(j).value;
                    i++;
                    j++;
                } else if (list.get(i).index < list2.get(j).index) {
                    i++;
                } else {
                    j++;
                }
            }
            return res;
        }
    }
}

package company.bloomberg.q1600;

import java.util.ArrayList;
import java.util.List;

public class Q1656 {
    class OrderedStream {
        String[] nums;
        int pointer;

        public OrderedStream(int n) {
            nums = new String[n + 1];
            pointer = 1;
        }

        public List<String> insert(int idKey, String value) {
            List<String> res = new ArrayList<>();
            nums[idKey] = value;
            while (pointer < nums.length && nums[pointer] != null) {
                res.add(nums[pointer++]);
            }
            return res;
        }
    }
}

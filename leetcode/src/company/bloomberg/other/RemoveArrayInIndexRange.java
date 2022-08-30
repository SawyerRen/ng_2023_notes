package company.bloomberg.other;

import java.util.ArrayList;
import java.util.List;

/**
 * Remove ints from an array.
 * <p>
 * Example:
 * <p>
 * Input: array = [-8, 3, -5, 1, 51, 56, 0, -5, 29, 43, 78, 75, 32, 76, 73, 76], ranges = [[5, 8], [10, 13], [3, 6], [20, 25]]
 * Output: [-8, 3, -5, 29, 43, 76, 73, 76]
 */
public class RemoveArrayInIndexRange {
    public static List<Integer> removeIndex(int[] nums, int[][] range) {
        int n = nums.length;
        boolean[] remove = new boolean[n];
        for (int[] r : range) {
            for (int i = r[0]; i <= r[1]; i++) {
                remove[i] = true;
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (!remove[i]) res.add(nums[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] array = {-8, 3, -5, 1, 51, 56, 0, -5, 29, 43, 78, 75, 32, 76, 73, 76};
        int[][] ranges = {{5, 8}, {10, 13}, {3, 6}, {20, 25}};
        System.out.println(removeIndex(array, ranges));
    }
}

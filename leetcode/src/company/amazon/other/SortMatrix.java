package company.amazon.other;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Given a 2d array in which each row is sorted and rotated, you need to come up with an algorithm which efficiently sort the entire 2d matrix in descenting order.
 * <p>
 * eg:
 * input: arr[][] = {
 * {41, 45, 20, 21},
 * {1 ,2, 3, 4},
 * {30, 42, 43, 29 },
 * {16, 17, 19, 10}
 * }
 * <p>
 * output: {
 * { 45, 43, 42, 41},
 * {30, 29, 21, 20},
 * {19, 17, 16, 10},
 * {4, 3, 2, 1}
 * }
 * <p>
 * Interviewer was expecting the solution to run with a complexity < O(n^3) solution.
 */
public class SortMatrix {
    static int[][] sort(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for (int i = 0; i < m; i++) {
            int minIndex = findMin(matrix[i]);
            System.out.println(minIndex);
            pq.add(new int[]{matrix[i][minIndex], i, minIndex, minIndex});
        }
        int[][] res = new int[m][n];
        int count = m * n - 1;
        while (!pq.isEmpty()) {
            int[] poll = pq.poll();
            int val = poll[0], row = poll[1], col = poll[2], minCol = poll[3];
            res[count / n][count % n] = val;
            count--;
            int nextCol = (col + 1) % n;
            if (nextCol != minCol) pq.add(new int[]{matrix[row][nextCol], row, nextCol, minCol});
        }
        return res;
    }

    static private int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[][] arr = {{41, 45, 20, 21},
                {1, 2, 3, 4},
                {30, 42, 43, 29},
                {16, 17, 19, 10}};
        System.out.println(Arrays.deepToString(sort(arr)));
    }
}

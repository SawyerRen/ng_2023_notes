package company.expedia.oa;

import java.util.Arrays;

public class DataUpdates {
    static int[] solution(int[] arr, int[][] ranges) {
        int[] count = new int[arr.length + 1];
        for (int[] range : ranges) {
            count[range[0]]++;
            count[range[1] + 1]--;
        }
        int c = 0;
        for (int i = 0; i < arr.length; i++) {
            c += count[i];
            int m = (int) Math.pow(-1, c);
            arr[i] *= m;
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 1, 1, 1};
        int[][] ranges = {{0, 2}, {1, 3}, {2, 4}};
        System.out.println(Arrays.toString(solution(arr, ranges)));
    }
}

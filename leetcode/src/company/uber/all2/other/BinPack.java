package company.uber.all2.other;

import java.lang.reflect.Array;
import java.util.Arrays;

public class BinPack {
    static int solution(int[] arr, int maxSum) {
        Arrays.sort(arr);
        int i = 0, j = arr.length - 1;
        while (i < j) {
            int n = arr[i];
            arr[i] = arr[j];
            arr[j] = n;
            i++;
            j--;
        }
        int n = arr.length, count = 0;
        int[] bins = new int[n];
        Arrays.fill(bins, maxSum);
        for (int cur = 0; cur < n; cur++) {
            int binIndex = 0;
            while (binIndex < count) {
                if (bins[binIndex] >= arr[cur]) {
                    bins[binIndex] -= arr[cur];
                    break;
                }
                binIndex++;
            }
            if (binIndex == count) {
                bins[count++] -= arr[cur];
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] weight = {2, 5, 4, 7, 1, 3, 8};
        int c = 10;
        System.out.println(solution(weight, c));
    }
}

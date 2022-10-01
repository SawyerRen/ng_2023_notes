package company.expedia.oa;

public class ArrayGenerator {
    int[] solution(int[] arr, int l, int r) {
        int n = arr.length;
        int[] res = new int[n];
        res[0] = Math.max(arr[0], l);
        int diff = res[0] - arr[0];
        for (int i = 1; i < n; i++) {
            res[i] = Math.max(res[i - 1], arr[i] + diff + 1);
            diff = res[i] - arr[i];
        }
        return res;
    }
}

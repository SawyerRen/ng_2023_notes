package company.expedia;

public class Q1326 {
    public int minTaps(int n, int[] ranges) {
        int[] arr = new int[n + 1];
        for (int i = 0; i < ranges.length; i++) {
            if (ranges[i] == 0) continue;
            int left = Math.max(0, i - ranges[i]);
            arr[left] = Math.max(arr[left], i + ranges[i]);
        }
        int count = 0, curMax = 0, curEnd = 0;
        for (int i = 0; i < arr.length && curEnd < n; i++) {
            curMax = Math.max(curMax, arr[i]);
            if (curEnd == i) {
                if (curMax == i) return -1;
                curEnd = curMax;
                count++;
            }
        }
        return count;
    }
}

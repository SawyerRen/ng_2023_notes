package company.uber.goodluck;

public class Q1151 {
    public int minSwaps(int[] data) {
        int total1 = 0;
        for (int i : data) {
            if (i == 1) total1++;
        }
        int left = 0, right = total1;
        int count1 = 0;
        for (int i = 0; i < right; i++) {
            if (data[i] == 1) count1++;
        }
        int res = total1 - count1;
        while (right < data.length) {
            if (data[right] == 1) count1++;
            if (data[left] == 1) count1--;
            res = Math.min(res, total1 - count1);
            left++;
            right++;
        }
        return res;
    }
}

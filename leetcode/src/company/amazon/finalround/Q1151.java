package company.amazon.finalround;

public class Q1151 {
    public int minSwaps(int[] data) {
        int total1 = 0;
        for (int i : data) {
            if (i == 1) total1++;
        }
        int count1 = 0;
        int i = 0, j = total1;
        for (int k = 0; k < j; k++) {
            if (data[k] == 1) count1++;
        }
        int res = total1 - count1;
        while (j < data.length) {
            if (data[i] == 1) count1--;
            if (data[j] == 1) count1++;
            res = Math.min(res, total1 - count1);
            i++;
            j++;
        }
        return res;
    }
}

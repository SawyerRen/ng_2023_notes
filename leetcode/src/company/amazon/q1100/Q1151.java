package company.amazon.q1100;

public class Q1151 {
    public int minSwaps(int[] data) {
        int count = 0;
        for (int datum : data) {
            if (datum == 1) count++;
        }
        int i = 0, j = count;
        int count1 = getCount1(data, i, j);
        int res = count - count1;
        while (j < data.length) {
            if (data[i] == 1) count1--;
            if (data[j] == 1) count1++;
            res = Math.min(res, count - count1);
            i++;
            j++;
        }
        return res;
    }

    private int getCount1(int[] data, int i, int j) {
        int count = 0;
        for (int k = i; k < j; k++) {
            if (data[k] == 1) count++;
        }
        return count;
    }
}

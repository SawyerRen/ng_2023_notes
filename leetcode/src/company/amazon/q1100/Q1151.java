package company.amazon.q1100;

public class Q1151 {
    public int minSwaps(int[] data) {
        int count = 0;
        for (int datum : data) {
            if (datum == 1) count++;
        }
        int left = 0, right = count;
        int oneInWindow = getOneInWindow(data, left, right);
        int res = count - oneInWindow;
        while (right < data.length) {
            if (data[left] == 1) oneInWindow--;
            if (data[right] == 1) oneInWindow++;
            res = Math.min(res, count - oneInWindow);
            left++;
            right++;
        }
        return res;
    }

    private int getOneInWindow(int[] data, int left, int right) {
        int count = 0;
        for (int i = left; i < right; i++) {
            if (data[i] == 1) count++;
        }
        return count;
    }
}

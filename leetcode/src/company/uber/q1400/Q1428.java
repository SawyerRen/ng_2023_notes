package company.uber.q1400;

import java.util.List;

public class Q1428 {
    interface BinaryMatrix {
        public int get(int row, int col);

        public List<Integer> dimensions();
    }

    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        int m = binaryMatrix.dimensions().get(0);
        int n = binaryMatrix.dimensions().get(1);
        int res = n;
        int i = 0, j = n - 1;
        while (i < m && j >= 0) {
            if (binaryMatrix.get(i, j) == 1) {
                res = Math.min(res, j);
                j--;
            } else {
                i++;
            }
        }
        return res == n ? -1 : res;
    }

    public int leftMostColumnWithOne1(BinaryMatrix binaryMatrix) {
        int m = binaryMatrix.dimensions().get(0);
        int n = binaryMatrix.dimensions().get(1);
        int res = n;
        for (int i = 0; i < m; i++) {
            int left = 0, right = n;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (binaryMatrix.get(i, mid) == 1) right = mid;
                else left = mid + 1;
            }
            res = Math.min(res, left);
        }
        return res == n ? -1 : res;
    }
}

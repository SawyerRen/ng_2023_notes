package company.uber.all1;

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
        for (int i = 0; i < m; i++) {
            int left = 0, right = n;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (binaryMatrix.get(i, mid) == 1) right = mid;
                else left = mid + 1;
            }
            res = Math.min(left, res);
        }
        return res == n ? -1 : res;
    }

    public int leftMostColumnWithOne1(BinaryMatrix binaryMatrix) {
        int m = binaryMatrix.dimensions().get(0);
        int n = binaryMatrix.dimensions().get(1);
        int row = 0, col = n - 1;
        while (row < m && col >= 0) {
            if (binaryMatrix.get(row, col) == 1) {
                col--;
            } else {
                row++;
            }
        }
        return col == n - 1 ? -1 : col + 1;
    }
}

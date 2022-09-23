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
        int col = n;
        for (int i = 0; i < m; i++) {
            int left = 0, right = n;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (binaryMatrix.get(i, mid) == 1) right = mid;
                else left = mid + 1;
            }
            col = Math.min(col, left);
        }
        return col == n ? -1 : col;
    }

    public int leftMostColumnWithOne1(BinaryMatrix binaryMatrix) {
        int m = binaryMatrix.dimensions().get(0);
        int n = binaryMatrix.dimensions().get(1);
        int i = 0, j = n - 1;
        while (i < m && j >= 0) {
            if (binaryMatrix.get(i, j) == 1) j--;
            else i++;
        }
        if (j == n - 1) return -1;
        return j + 1;
    }
}

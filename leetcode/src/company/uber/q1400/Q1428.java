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
        int i = 0, j = n - 1;
        while (i < m && j >= 0) {
            while (j >= 0 && binaryMatrix.get(i, j) == 1) {
                j--;
            }
            i++;
        }
        return j == n - 1 ? -1 : j + 1;
    }
}

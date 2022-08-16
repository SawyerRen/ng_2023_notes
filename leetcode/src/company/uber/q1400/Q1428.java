package company.uber.q1400;

import java.util.List;

public class Q1428 {
    interface BinaryMatrix {
        public int get(int row, int col);

        public List<Integer> dimensions();
    }

    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        Integer m = binaryMatrix.dimensions().get(0);
        Integer n = binaryMatrix.dimensions().get(1);
        int i = 0, j = n - 1;
        while (i < m && j >= 0) {
            if (binaryMatrix.get(i, j) == 1) {
                j--;
            } else {
                i++;
            }
        }
        if (j == n - 1) return -1;
        return j + 1;
    }
}

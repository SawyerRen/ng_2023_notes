package company.amazon.q900;

import java.util.PriorityQueue;
import java.util.Random;

public class Q973 {
    public int[][] kClosest(int[][] points, int k) {
        int left = 0, right = points.length - 1;
        while (left < right) {
            int pivotIndex = findPivot(points, left, right);
            if (pivotIndex >= k) right = pivotIndex;
            else left = pivotIndex + 1;
        }
        int[][] res = new int[k][2];
        for (int i = 0; i < res.length; i++) {
            res[i] = points[i];
        }
        return res;
    }

    private int findPivot(int[][] points, int left, int right) {
        int randomIndex = left + new Random().nextInt(right - left + 1);
        swap(points, left, randomIndex);
        int pivot = dist(points[left]);
        int i = left, j = right;
        while (i < j) {
            while (i < j && dist(points[j]) >= pivot) j--;
            while (i < j && dist(points[i]) <= pivot) i++;
            if (i < j) swap(points, i, j);
        }
        swap(points, left, i);
        return i;
    }

    private void swap(int[][] points, int i, int j) {
        int[] p = points[i];
        points[i] = points[j];
        points[j] = p;
    }

    int dist(int[] p) {
        return p[0] * p[0] + p[1] * p[1];
    }

    public int[][] kClosest1(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> dist(b) - dist(a));
        for (int[] point : points) {
            pq.add(point);
            if (pq.size() > k) pq.poll();
        }
        int[][] res = new int[k][2];
        for (int i = 0; i < res.length; i++) {
            res[i] = pq.poll();
        }
        return res;
    }


}

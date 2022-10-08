package company.bloomberg.vo;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Q295 {
    class MedianFinder {
        PriorityQueue<Integer> small = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> large = new PriorityQueue<>();

        public MedianFinder() {

        }

        public void addNum(int num) {
            if (small.size() == large.size()) {
                small.add(num);
                large.add(small.poll());
            } else {
                large.add(num);
                small.add(large.poll());
            }
        }

        public double findMedian() {
            if (small.size() == large.size()) {
                return (small.peek() + large.peek()) / 2.0;
            } else {
                return large.peek();
            }
        }
    }
}

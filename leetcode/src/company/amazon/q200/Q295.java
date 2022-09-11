package company.amazon.q200;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Q295 {
    class MedianFinder {
        PriorityQueue<Integer> large = new PriorityQueue<>();
        PriorityQueue<Integer> small = new PriorityQueue<>(Comparator.reverseOrder());

        public MedianFinder() {

        }

        public void addNum(int num) {
            if (large.size() == small.size()) {
                small.add(num);
                large.add(small.poll());
            } else {
                large.add(num);
                small.add(large.poll());
            }
        }

        public double findMedian() {
            if (large.size() == small.size()) return (double) (large.peek() + small.peek()) / 2.0;
            else return (double) large.peek();
        }
    }
}

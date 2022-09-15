package company.amazon.finalround;

import java.util.PriorityQueue;

public class Q295 {
    class MedianFinder {
        PriorityQueue<Integer> large = new PriorityQueue<>();
        PriorityQueue<Integer> small = new PriorityQueue<>((a, b) -> b - a);

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
            if (large.size() == small.size()) {
                return (large.peek() + small.peek()) / 2.0;
            } else {
                return large.peek();
            }
        }
    }

}

package company.amazon.q200;

import java.util.PriorityQueue;

public class Q295 {
    class MedianFinder {
        PriorityQueue<Integer> large = new PriorityQueue<>((a, b) -> a - b);
        PriorityQueue<Integer> small = new PriorityQueue<>((a, b) -> b - a);
        boolean even = true;

        public MedianFinder() {

        }

        public void addNum(int num) {
            if (even) {
                small.add(num);
                large.add(small.poll());
            } else {
                large.add(num);
                small.add(large.poll());
            }
            even = !even;
        }

        public double findMedian() {
            if (even) {
                return (double) (small.peek() + large.peek()) / 2.0;
            } else {
                return (double) large.peek();
            }
        }
    }
}

package company.uber.lastround;

import java.util.LinkedList;

public class Q362 {
    class HitCounter {
        LinkedList<Integer> list = new LinkedList<>();

        public HitCounter() {

        }

        public void hit(int timestamp) {
            list.addLast(timestamp);
        }

        public int getHits(int timestamp) {
            while (!list.isEmpty() && list.getFirst() + 300 <= timestamp) {
                list.removeFirst();
            }
            return list.size();
        }
    }
}

package company.amazon.q2100;

import java.util.TreeSet;

public class Q2102 {
    class Location implements Comparable<Location> {
        String name;
        int score;

        public Location(String name, int score) {
            this.name = name;
            this.score = score;
        }

        public int compareTo(Location l) {
            return this.score == l.score ? this.name.compareTo(l.name) : l.score - this.score;
        }
    }

    class SORTracker {
        TreeSet<Location> treeSet = new TreeSet<>();
        Location lastReturned = new Location("", Integer.MAX_VALUE);

        public SORTracker() {

        }

        public void add(String name, int score) {
            Location location = new Location(name, score);
            treeSet.add(location);
            if (location.compareTo(lastReturned) < 0) {
                lastReturned = treeSet.lower(lastReturned);
            }
        }

        public String get() {
            lastReturned = treeSet.higher(lastReturned);
            return lastReturned.name;
        }
    }
}

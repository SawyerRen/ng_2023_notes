package company.uber.lastround;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Q341 {
    public interface NestedInteger {

        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        public boolean isInteger();

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger();

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return empty list if this NestedInteger holds a single integer
        public List<NestedInteger> getList();
    }

    public class NestedIterator implements Iterator<Integer> {
        LinkedList<Integer> list = new LinkedList<>();

        public NestedIterator(List<NestedInteger> nestedList) {
            buildList(nestedList);
        }

        private void buildList(List<NestedInteger> nestedList) {
            for (NestedInteger nestedInteger : nestedList) {
                if (nestedInteger.isInteger()) {
                    list.add(nestedInteger.getInteger());
                } else {
                    buildList(nestedInteger.getList());
                }
            }
        }

        @Override
        public Integer next() {
            return list.removeFirst();
        }

        @Override
        public boolean hasNext() {
            return !list.isEmpty();
        }
    }
}

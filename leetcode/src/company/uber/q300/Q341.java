package company.uber.q300;

import java.util.*;

public class Q341 {
    private interface NestedInteger {

        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        public boolean isInteger();

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger();

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return empty list if this NestedInteger holds a single integer
        public List<NestedInteger> getList();
    }

    class NestedIterator implements Iterator<Integer> {
        Stack<NestedInteger> stack = new Stack<>();

        public NestedIterator(List<NestedInteger> nestedList) {
            buildStack(nestedList);
        }

        private void buildStack(List<NestedInteger> nestedList) {
            for (int i = nestedList.size() - 1; i >= 0; i--) {
                stack.push(nestedList.get(i));
            }
        }

        @Override
        public Integer next() {
            if (!hasNext()) return null;
            return stack.pop().getInteger();
        }

        @Override
        public boolean hasNext() {
            while (!stack.isEmpty() && !stack.peek().isInteger()) {
                buildStack(stack.pop().getList());
            }
            return !stack.isEmpty();
        }
    }

    class NestedIterator1 implements Iterator<Integer> {
        LinkedList<Integer> valList = new LinkedList<>();

        public NestedIterator1(List<NestedInteger> nestedList) {
            buildList(nestedList);
        }

        private void buildList(List<NestedInteger> list) {
            for (NestedInteger nestedInteger : list) {
                if (nestedInteger.isInteger()) {
                    valList.addLast(nestedInteger.getInteger());
                } else {
                    buildList(nestedInteger.getList());
                }
            }
        }

        @Override
        public Integer next() {
            if (!hasNext()) return null;
            return valList.removeFirst();
        }

        @Override
        public boolean hasNext() {
            return !valList.isEmpty();
        }
    }
}

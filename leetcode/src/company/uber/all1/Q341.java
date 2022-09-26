package company.uber.all1;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

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
            buildStack(stack, nestedList);
        }

        private void buildStack(Stack<NestedInteger> stack, List<NestedInteger> nestedList) {
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
                buildStack(stack, stack.pop().getList());
            }
            return !stack.isEmpty();
        }
    }

    class NestedIterator1 implements Iterator<Integer> {
        LinkedList<Integer> list;

        public NestedIterator1(List<NestedInteger> nestedList) {
            list = new LinkedList<>();
            helper(list, nestedList);
        }

        private void helper(LinkedList<Integer> list, List<NestedInteger> nestedList) {
            for (NestedInteger nestedInteger : nestedList) {
                if (nestedInteger.isInteger()) {
                    list.add(nestedInteger.getInteger());
                } else {
                    helper(list, nestedInteger.getList());
                }
            }
        }

        @Override
        public Integer next() {
            if (!hasNext()) return -1;
            return list.removeFirst();
        }

        @Override
        public boolean hasNext() {
            return !list.isEmpty();
        }
    }
}

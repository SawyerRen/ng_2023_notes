package company.bloomberg.goodluck;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Q1472 {
    class BrowserHistory {
        List<String> list = new ArrayList<>();
        int index = 0, right = 0;

        public BrowserHistory(String homepage) {
            list.add(homepage);
        }

        public void visit(String url) {
            if (index == list.size() - 1) {
                list.add(url);
                index++;
            } else {
                index++;
                list.set(index, url);
            }
            right = index;
        }

        public String back(int steps) {
            index = Math.max(0, index - steps);
            return list.get(index);
        }

        public String forward(int steps) {
            index = Math.min(right, index + steps);
            return list.get(index);
        }
    }

    class BrowserHistory1 {
        Stack<String> history = new Stack<>();
        Stack<String> forward = new Stack<>();

        public BrowserHistory1(String homepage) {
            history.push(homepage);
        }

        public void visit(String url) {
            history.push(url);
            forward.clear();
        }

        public String back(int steps) {
            while (history.size() > 1 && steps-- > 0) {
                forward.push(history.pop());
            }
            return history.peek();
        }

        public String forward(int steps) {
            while (!forward.isEmpty() && steps-- > 0) {
                history.push(forward.pop());
            }
            return history.peek();
        }
    }
}

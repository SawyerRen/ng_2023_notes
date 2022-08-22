package company.bloomberg.q1400;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Q1472 {
    class BrowserHistory {
        List<String> history = new ArrayList<>();
        int cur, right;

        public BrowserHistory(String homepage) {
            history.add(homepage);
            cur = 0;
            right = 0;
        }

        public void visit(String url) {
            cur++;
            if (cur == history.size() - 1) {
                history.add(url);
            } else {
                history.set(cur, url);
            }
            right = cur;
        }

        public String back(int steps) {
            cur = Math.max(0, cur - steps);
            return history.get(cur);
        }

        public String forward(int steps) {
            cur = Math.min(cur + steps, right);
            return history.get(cur);
        }
    }
}

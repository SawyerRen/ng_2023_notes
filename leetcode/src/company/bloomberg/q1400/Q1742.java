package company.bloomberg.q1400;

import java.util.ArrayList;
import java.util.List;

public class Q1742 {
    class BrowserHistory {
        List<String> history = new ArrayList<>();
        int cur = 0, right = 0;

        public BrowserHistory(String homepage) {
            history.add(homepage);
        }

        public void visit(String url) {
            if (cur == history.size() - 1) {
                history.add(url);
                cur++;
            } else {
                cur++;
                history.set(cur, url);
            }
            right = cur;
        }

        public String back(int steps) {
            cur = Math.max(0, cur - steps);
            return history.get(cur);
        }

        public String forward(int steps) {
            cur = Math.min(right, cur + steps);
            return history.get(cur);
        }
    }
}

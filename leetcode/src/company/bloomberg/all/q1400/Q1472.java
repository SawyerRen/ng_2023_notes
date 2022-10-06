package company.bloomberg.all.q1400;

import java.util.ArrayList;
import java.util.List;

public class Q1472 {
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
            cur = Math.max(cur - steps, 0);
            return history.get(cur);
        }

        public String forward(int steps) {
            cur = Math.min(cur + steps, right);
            return history.get(cur);
        }
    }
}

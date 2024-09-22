package company.bloomberg.goodluck;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// 这题两种解法，看你觉得哪个更简单
public class Q1472 {
    // 第一种解法
    class BrowserHistory {
        List<String> list = new ArrayList<>(); // 保存浏览记录
        int index = 0, right = 0; // index表示当前的页面，right表示最前面的页面index

        public BrowserHistory(String homepage) {
            list.add(homepage);
        }

        public void visit(String url) {
            // 如果現在在最前面的页面，加上这个url即可
            if (index == list.size() - 1) {
                list.add(url);
                index++;
            // 否则，需要把index的下一个页面设置成这个url
            } else {
                index++;
                list.set(index, url);
            }
            // 更新right为当前index，因为visit之后，这个url就是最新的页面了
            right = index;
        }

        public String back(int steps) {
            // 从当前页面后退steps个页面得到index
            index = Math.max(0, index - steps);
            return list.get(index);
        }

        public String forward(int steps) {
            // 从当前页面向前steps个页面得到index
            index = Math.min(right, index + steps);
            return list.get(index);
        }
    }

    // 第二种解法
    // 两个stack，在后退的过程中，把历史页面弹出加入未来页面
    // 在前进的过程中，把未来的页面弹出加入历史页面
    // 保持历史页面的栈顶始终是当前页面
    class BrowserHistory1 {
        Stack<String> history = new Stack<>(); // 表示历史页面
        Stack<String> forward = new Stack<>(); // 表示向前的页面

        public BrowserHistory1(String homepage) {
            history.push(homepage);
        }
        
        // 在历史页面中添加url，把向前页面清空
        public void visit(String url) {
            history.push(url);
            forward.clear();
        }
        
        // 在后退的过程中，把history中的页面弹出并加入到向前的页面中
        public String back(int steps) {
            while (history.size() > 1 && steps-- > 0) {
                forward.push(history.pop());
            }
            return history.peek();
        }
        
        // 在前进的过程中，把未来的页面弹出加入历史页面
        public String forward(int steps) {
            while (!forward.isEmpty() && steps-- > 0) {
                history.push(forward.pop());
            }
            return history.peek();
        }
    }
}

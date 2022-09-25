package company.uber.all1;

import java.util.List;
import java.util.Stack;

public class Q636 {
    public int[] exclusiveTime(int n, List<String> logs) {
        Stack<Log> stack = new Stack<>();
        int[] res = new int[n];
        for (String s : logs) {
            Log log = new Log(s);
            if (!stack.isEmpty() && !log.isStart) {
                Log log2 = stack.pop();
                int time = log.time - log2.time + 1;
                res[log.id] += time;
                if (!stack.isEmpty()) res[stack.peek().id] -= time;
            } else {
                stack.push(log);
            }
        }
        return res;
    }

    class Log {
        int id;
        int time;
        boolean isStart;

        public Log(String s) {
            String[] split = s.split(":");
            id = Integer.parseInt(split[0]);
            time = Integer.parseInt(split[2]);
            isStart = split[1].equals("start");
        }
    }
}

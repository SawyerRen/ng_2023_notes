package company.uber.lastround;

import java.util.List;
import java.util.Stack;

public class Q636 {
    public int[] exclusiveTime(int n, List<String> logs) {
        Stack<Node> stack = new Stack<>();
        int[] res = new int[n];
        for (String s : logs) {
            Node node = new Node(s);
            if (node.isStart) {
                stack.add(node);
            } else {
                Node pop = stack.pop();
                int time = node.time - pop.time + 1;
                res[node.id] += time;
                if (!stack.isEmpty()) {
                    res[stack.peek().id] -= time;
                }
            }
        }
        return res;
    }

    class Node {
        int id;
        int time;
        boolean isStart;

        public Node(String s) {
            String[] split = s.split(":");
            id = Integer.parseInt(split[0]);
            time = Integer.parseInt(split[2]);
            isStart = split[1].equals("start");
        }
    }
}

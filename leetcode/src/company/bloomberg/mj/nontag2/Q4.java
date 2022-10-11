package company.bloomberg.mj.nontag2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q4 {
    List<String> solution(String s) {
        Map<Integer, List<String>> map = new HashMap<>();
        int depth = 0, max = 0;
        StringBuilder builder = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                map.putIfAbsent(depth, new ArrayList<>());
                map.get(depth).add(builder.toString());
                depth++;
                max = Math.max(max ,depth);
                builder = new StringBuilder();
            } else if (c == ')') {
                map.putIfAbsent(depth, new ArrayList<>());
                map.get(depth).add(builder.toString());
                depth--;
                builder = new StringBuilder();
            } else {
                builder.append(c);
            }
        }
        return map.get(max);
    }
}

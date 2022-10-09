package company.bloomberg.r2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GetStringWithMaxDepth {
    List<String> solution(String s) {
        Map<Integer, List<String>> map = new HashMap<>();
        int depth = 0;
        int maxDepth = 0;
        StringBuilder builder = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                map.putIfAbsent(depth, new ArrayList<>());
                map.get(depth).add(builder.toString());
                builder = new StringBuilder();
                depth++;
                maxDepth = Math.max(maxDepth, depth);
            } else if (c == ')') {
                map.putIfAbsent(depth, new ArrayList<>());
                map.get(depth).add(builder.toString());
                builder = new StringBuilder();
                depth--;
            } else {
                builder.append(c);
            }
        }
        return map.get(maxDepth);
    }
}

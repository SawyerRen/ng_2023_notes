package company.bloomberg.mj.nontag;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GetStringsInMaxDepth {
    List<String> solution(String s) {
        int depth = 0, maxDepth = 0;
        Map<Integer, List<String>> map = new HashMap<>();
        StringBuilder builder = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                map.putIfAbsent(depth, new ArrayList<>());
                if (builder.length() > 0) map.get(depth).add(builder.toString());
                builder = new StringBuilder();
                depth++;
                maxDepth = Math.max(maxDepth, depth);
            } else if (c == ')') {
                map.putIfAbsent(depth, new ArrayList<>());
                if (builder.length() > 0) map.get(depth).add(builder.toString());
                builder = new StringBuilder();
                depth--;
            } else {
                builder.append(c);
            }
        }
        return map.get(maxDepth);
    }
}

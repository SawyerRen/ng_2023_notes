package company.amazon.q200;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q249 {
    public List<List<String>> groupStrings(String[] strings) {
        Map<String, List<String>> map = new HashMap<>();
        for (String string : strings) {
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < string.length() - 1; i++) {
                char c1 = string.charAt(i);
                char c2 = string.charAt(i + 1);
                int diff = c2 - c1;
                if (diff < 0) diff += 26;
                builder.append(diff).append(",");
            }
            map.putIfAbsent(builder.toString(), new ArrayList<>());
            map.get(builder.toString()).add(string);
        }
        return new ArrayList<>(map.values());
    }
}

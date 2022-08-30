package company.bloomberg.q100;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q140 {
    Map<String, List<String>> map = new HashMap<>();

    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> res = new ArrayList<>();
        if (s.length() == 0) {
            res.add("");
            return res;
        }
        if (map.containsKey(s)) return map.get(s);
        for (String word : wordDict) {
            if (s.startsWith(word)) {
                List<String> nextList = wordBreak(s.substring(word.length()), wordDict);
                for (String s1 : nextList) {
                    if (s1.equals("")) {
                        res.add(word);
                    } else {
                        res.add(word + " " + s1);
                    }
                }
            }
        }
        map.put(s, res);
        return res;
    }
}

package company.uber.q600;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q692 {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        List[] lists = new List[words.length + 1];
        for (String word : map.keySet()) {
            Integer count = map.get(word);
            if (lists[count] == null) lists[count] = new ArrayList<String>();
            lists[count].add(word);
        }
        List<String> res = new ArrayList<>();
        for (int i = lists.length - 1; i >= 0; i--) {
            if (k == 0) break;
            if (lists[i] != null) {
                List<String> list = lists[i];
                list.sort(String::compareTo);
                for (String word : list) {
                    res.add(word);
                    k--;
                    if (k == 0) break;
                }
            }
        }
        return res;
    }
}

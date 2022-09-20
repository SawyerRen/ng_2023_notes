package company.expedia;

import java.util.HashMap;
import java.util.Map;

public class Q1487 {
    public String[] getFolderNames(String[] names) {
        Map<String, Integer> map = new HashMap<>();
        String[] res = new String[names.length];
        for (int i = 0; i < names.length; i++) {
            if (map.containsKey(names[i])) {
                int num = map.get(names[i]);
                String name = names[i] + "(" + num + ")";
                while (map.containsKey(name)) {
                    num++;
                    name = names[i] + "(" + num + ")";
                }
                res[i] = name;
                num++;
                map.put(name, 1);
                map.put(names[i], num);
            } else {
                res[i] = names[i];
                map.put(names[i], 1);
            }
        }
        return res;
    }
}

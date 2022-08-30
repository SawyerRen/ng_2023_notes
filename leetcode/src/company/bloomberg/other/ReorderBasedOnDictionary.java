package company.bloomberg.other;

import java.util.*;

public class ReorderBasedOnDictionary {
    public static List<List<String>> reorder(List<List<String>> list, Map<String, String> map) {
        Map<String, List<String>> levelMap = new HashMap<>();
        for (List<String> employee : list) {
            levelMap.putIfAbsent(employee.get(1), new ArrayList<>());
            levelMap.get(employee.get(1)).add(employee.get(0));
        }
        Map<String, List<String>> reportMap = new HashMap<>();
        String top = "";
        for (String level1 : map.keySet()) {
            String level2 = map.get(level1);
            reportMap.putIfAbsent(level2, new ArrayList<>());
            reportMap.get(level2).add(level1);
            if (!map.containsKey(level2)) top = level2;
        }
        List<List<String>> res = new ArrayList<>();
        Queue<String> queue = new LinkedList<>();
        queue.add(top);
        while (!queue.isEmpty()) {
            String level = queue.poll();
            if (reportMap.containsKey(level)) {
                for (String nextLevel : reportMap.get(level)) {
                    List<String> names = levelMap.get(nextLevel);
                    for (String name : names) {
                        res.add(Arrays.asList(name, nextLevel));
                    }
                    queue.add(nextLevel);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<String, String>() {{
            put("CTO", "CEO");
            put("Manager", "CTO");
            put("Engineer", "Manager");
            put("CFO", "CEO");
        }};
        List<List<String>> list = new ArrayList<>();
        list.add(Arrays.asList("John","Manager"));
        list.add(Arrays.asList("Sally","CTO"));
        list.add(Arrays.asList("Drax","Engineer"));
        list.add(Arrays.asList("Daniel","Engineer"));
        list.add(Arrays.asList("Bob","CFO"));
        list.add(Arrays.asList("Sam","CEO"));
        List<List<String>> res = reorder(list, map);
        System.out.println(res);
    }
}

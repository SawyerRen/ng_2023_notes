package company.bloomberg.all.other;

import java.util.*;

public class ReorderBasedOnDictionary {
    public static List<List<String>> reorder(List<List<String>> list, Map<String, String> map) {
        Map<String, Set<String>> reportMap = new HashMap<>();
        String top = "";
        for (String s : map.keySet()) {
            String s1 = map.get(s);
            if (!map.containsKey(s1)) top = s1;
            reportMap.putIfAbsent(s1, new HashSet<>());
            reportMap.get(s1).add(s);
        }
        Map<String, List<String>> levelMap = new HashMap<>();
        for (List<String> s : list) {
            levelMap.putIfAbsent(s.get(1), new ArrayList<>());
            levelMap.get(s.get(1)).add(s.get(0));
        }
        List<List<String>> res = new ArrayList<>();
        Queue<String> queue = new LinkedList<>();
        queue.add(top);
        while (!queue.isEmpty()) {
            String poll = queue.poll();
            for (String name : levelMap.get(poll)) {
                res.add(new ArrayList<>(Arrays.asList(poll, name)));
            }
            if (reportMap.containsKey(poll))
                queue.addAll(reportMap.get(poll));
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
        list.add(Arrays.asList("John", "Manager"));
        list.add(Arrays.asList("Sally", "CTO"));
        list.add(Arrays.asList("Drax", "Engineer"));
        list.add(Arrays.asList("Daniel", "Engineer"));
        list.add(Arrays.asList("Bob", "CFO"));
        list.add(Arrays.asList("Sam", "CEO"));
        List<List<String>> res = reorder(list, map);
        System.out.println(res);
    }
}

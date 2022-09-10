package company.amazon.q600;

import java.util.*;

public class Q690 {
    class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;
    }

    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> map = new HashMap<>();
        for (Employee employee : employees) {
            map.put(employee.id, employee);
        }
        Map<Employee, Set<Integer>> subMap = new HashMap<>();
        for (Employee employee : employees) {
            subMap.putIfAbsent(employee, new HashSet<>());
            subMap.get(employee).addAll(employee.subordinates);
        }
        Queue<Employee> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        queue.add(map.get(id));
        visited.add(id);
        int res = 0;
        while (!queue.isEmpty()) {
            Employee employee = queue.poll();
            res += employee.importance;
            for (Integer nextId : subMap.get(employee)) {
                if (visited.contains(nextId)) continue;
                visited.add(nextId);
                queue.add(map.get(nextId));
            }
        }
        return res;
    }
}

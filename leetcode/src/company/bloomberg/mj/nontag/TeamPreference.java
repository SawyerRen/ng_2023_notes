package company.bloomberg.mj.nontag;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TeamPreference {
    Map<String, String> solution(Map<String, List<String>> employeeMap, Map<String, List<String>> teamMap) {
        Map<String, Boolean> vacantEmployee = new HashMap<>();
        for (String s : employeeMap.keySet()) {
            vacantEmployee.put(s, true);
        }
        Map<String, String> teamEmployeeMap = new HashMap<>();
        for (String s : teamMap.keySet()) {
            teamEmployeeMap.put(s, "");
        }
        int freeCount = vacantEmployee.size();
        while (freeCount > 0) {
            for (String e : employeeMap.keySet()) {
                if (!vacantEmployee.get(e)) continue;
                List<String> prefer = employeeMap.get(e);
                for (String team : prefer) {
                    if (teamEmployeeMap.get(team).equals("")) {
                        teamEmployeeMap.put(team, e);
                        vacantEmployee.put(e, false);
                        freeCount--;
                    } else {
                        String e2 = teamEmployeeMap.get(team);
                        if (teamPreferOver(teamMap, team, e, e2)) {
                            teamEmployeeMap.put(team, e);
                            vacantEmployee.put(e, false);
                            vacantEmployee.put(e2, true);
                        }
                    }
                }
            }
        }
        return teamEmployeeMap;
    }

    private boolean teamPreferOver(Map<String, List<String>> teamMap, String team, String e1, String e2) {
        for (String e : teamMap.get(team)) {
            if (e.equals(e1)) return true;
            if (e.equals(e2)) return true;
        }
        return false;
    }
}

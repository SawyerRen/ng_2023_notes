package company.bloomberg.r2;

import java.util.*;

public class TeamPreference {
    Map<String, String> solution(Map<String, List<String>> employeePrefer, Map<String, List<String>> teamPrefer) {
        int freeCount = employeePrefer.size();
        Map<String, Boolean> vacantEmployee = new HashMap<>();
        for (String s : employeePrefer.keySet()) {
            vacantEmployee.put(s, true);
        }
        Map<String, String> teamEmployee = new HashMap<>();
        for (String s : teamPrefer.keySet()) {
            teamEmployee.put(s, "");
        }
        while (freeCount > 0) {
            for (String e : employeePrefer.keySet()) {
                if (!vacantEmployee.get(e)) continue;
                List<String> list = teamPrefer.get(e);
                for (String team : list) {
                    if (teamEmployee.get(team).equals("")) {
                        teamEmployee.put(team, e);
                        vacantEmployee.put(e, false);
                        freeCount--;
                        break;
                    } else {
                        String e2 = teamEmployee.get(team);
                        if (preferOver(teamPrefer, team, e, e2)) {
                            teamEmployee.put(team, e);
                            vacantEmployee.put(e, false);
                            vacantEmployee.put(e2, true);
                            break;
                        }
                    }
                }
            }
        }
        return teamEmployee;
    }

    private boolean preferOver(Map<String, List<String>> teamPrefer, String team, String e, String e2) {
        for (String s : teamPrefer.get(team)) {
            if (s.equals(e)) return true;
            if (s.equals(e2)) return false;
        }
        return false;
    }
}

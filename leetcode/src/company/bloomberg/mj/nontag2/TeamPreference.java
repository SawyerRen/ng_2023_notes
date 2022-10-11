package company.bloomberg.mj.nontag2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class TeamPreference {
    Map<String, String> solution(Map<String, List<String>> employeeMap, Map<String, List<String>> teamMap) {
        Map<String, Boolean> vacantE = new HashMap<>();
        for (String s : employeeMap.keySet()) {
            vacantE.put(s, true);
        }
        Map<String, String> map = new HashMap<>();
        for (String team : teamMap.keySet()) {
            map.put(team, "");
        }
        int freeCount = employeeMap.size();
        while (freeCount > 0) {
            for (String e : employeeMap.keySet()) {
                if (!vacantE.get(e)) continue;
                for (String team : employeeMap.get(e)) {
                    if (map.get(team).equals("")) {
                        map.put(team, e);
                        freeCount--;
                        vacantE.put(e, false);
                        break;
                    } else {
                        String e2 = map.get(team);
                        if (preferOver(teamMap.get(team), e, e2)) {
                            map.put(team, e);
                            vacantE.put(e, false);
                            vacantE.put(e2, true);
                            break;
                        }
                    }
                }
            }
        }
        return map;
    }

    private boolean preferOver(List<String> list, String e, String e2) {
        for (String s : list) {
            if (s.equals(e)) return true;
            if (s.equals(e2)) return false;
        }
        return false;
    }
}

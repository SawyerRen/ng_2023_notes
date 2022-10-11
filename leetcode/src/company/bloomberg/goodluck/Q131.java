package company.bloomberg.goodluck;

import java.util.ArrayList;
import java.util.List;

public class Q131 {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        helper(res, new ArrayList<String>(), s);
        return res;
    }

    private void helper(List<List<String>> res, ArrayList<String> list, String s) {
        if (s.equals("")) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < s.length(); i++) {
            if (valid(s, 0, i)) {
                list.add(s.substring(0, i + 1));
                helper(res, list, s.substring(i + 1));
                list.remove(list.size() - 1);
            }
        }
    }

    private boolean valid(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}

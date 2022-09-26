package company.uber.all1;

public class Q14 {
    public String longestCommonPrefix(String[] strs) {
        String res = strs[0];
        for (String str : strs) {
            while (!str.startsWith(res)) {
                res = res.substring(0, res.length() - 1);
            }
        }
        return res;
    }
}

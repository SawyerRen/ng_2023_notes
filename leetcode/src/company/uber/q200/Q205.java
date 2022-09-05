package company.uber.q200;

public class Q205 {
    public boolean isIsomorphic(String s, String t) {
        int[] index1 = new int[256];
        int[] index2 = new int[256];
        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            if (index1[c1] != index2[c2]) return false;
            index1[c1] = i + 1;
            index2[c2] = i + 1;
        }
        return true;
    }
}

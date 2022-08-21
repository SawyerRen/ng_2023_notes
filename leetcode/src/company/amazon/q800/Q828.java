package company.amazon.q800;

public class Q828 {
    public int uniqueLetterString(String s) {
        int[] contribution = new int[26];
        int[] lastOccur = new int[26];
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int totalSubstringEndHere = i + 1;
            contribution[c - 'A'] = totalSubstringEndHere - lastOccur[c - 'A'];
            for (int j = 0; j < 26; j++) {
                res += contribution[j];
            }
            lastOccur[c - 'A'] = i + 1;
        }
        return res;
    }
}

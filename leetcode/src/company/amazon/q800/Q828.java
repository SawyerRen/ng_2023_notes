package company.amazon.q800;

public class Q828 {
    public int uniqueLetterString(String s) {
        int[] len = new int[26];
        int[] lastOccur = new int[26];
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            len[c - 'A'] = i + 1 - lastOccur[c - 'A'];
            for (int j = 0; j < 26; j++) {
                res += len[j];
            }
            lastOccur[c - 'A'] = i + 1;
        }
        return res;
    }
}

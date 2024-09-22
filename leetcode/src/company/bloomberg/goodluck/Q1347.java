package company.bloomberg.goodluck;

public class Q1347 {
    // 记录两个字符串不相同的字符出现的次数
    // 因为只要替换一个字符，就可以解决两个不同的字符
    // 比如说，"a"和"b"虽然相差一个a和一个b，但是只需要替换一次就可以变成一样
    // 所以最后的结果要除以2
    public int minSteps(String s, String t) {
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }
        int res = 0;
        for (int i : count) {
            res += Math.abs(i); // 绝对值
        }
        return res / 2; // 同上，结果除以2
    }
}

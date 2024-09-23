package company.bloomberg.mj.nontag;

import java.util.ArrayList;
import java.util.List;

public class BinaryStringPermutation {
    /**
     * 给一个 binary string: 里面有special char， like *，you can change that special char to either 0 or 1,
     * print out all possible combo, ex: input: 1*0  -> output: 110, 100.
     */
    static public List<String> solution(String s) {
        List<String> res = new ArrayList<>();
        StringBuilder builder = new StringBuilder();
        helper(res, builder, s, 0);
        return res;
    }

    static private void helper(List<String> res, StringBuilder builder, String s, int i) {
        if (i == s.length()) {
            res.add(builder.toString());
            return;
        }
        char c = s.charAt(i);
        if (c != '*') {
            builder.append(c);
            helper(res, builder, s, i + 1);
            builder.setLength(builder.length()-1);
        } else {
            for (int j = 0; j < 2; j++) {
                builder.append(j);
                helper(res, builder, s, i + 1);
                builder.setLength(builder.length()-1);
            }
        }
    }

    public static void main(String[] args) {
        String s = "1*0";
        List<String> res = solution(s);
        for (String re : res) {
            System.out.println(re);
        }
    }
}

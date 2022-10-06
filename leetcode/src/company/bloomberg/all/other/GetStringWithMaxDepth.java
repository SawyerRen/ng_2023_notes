package company.bloomberg.all.other;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * *
 * <p>
 * "abc(def)ghi" => ["def"]
 * "abc(def[ghi]jkl)mno" => ["ghi"]
 * "abc(def[ghi]jkl)mno{vfr}" => ["ghi"]
 * "abc(def)ghi[jkl]mno" => ["def", "jkl"]
 * <p>
 * (), [], {}
 * <p>
 * "abc(def[ghi]jkl)mno" => ["ghi"]
 * <p>
 * return ArrayList<>();
 */
public class GetStringWithMaxDepth {
    static List<String> getStrings(String s) {
        int depth = 0, maxDepth = 0;
        Map<Integer, List<String>> map = new HashMap<>();
        StringBuilder builder = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                map.putIfAbsent(depth, new ArrayList<>());
                map.get(depth).add(builder.toString());
                builder = new StringBuilder();
                depth++;
                maxDepth = Math.max(depth, maxDepth);
            } else if (c == ')' || c == ']' || c == '}') {
                map.putIfAbsent(depth, new ArrayList<>());
                map.get(depth).add(builder.toString());
                builder = new StringBuilder();
                depth--;
            } else {
                builder.append(c);
            }
        }
        return map.get(maxDepth);
    }

    public static void main(String[] args) {
        System.out.println(getStrings("abc(def)ghi"));
        System.out.println(getStrings("abc(def[ghi]jkl)mno"));
        System.out.println(getStrings("abc(def[ghi]jkl)mno{vfr}"));
        System.out.println(getStrings("abc(def)ghi[jkl]mno"));
        System.out.println(getStrings("abc(def[ghi]jkl)mno"));
    }
}

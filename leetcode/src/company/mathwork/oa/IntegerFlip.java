package company.mathwork.oa;

import java.util.HashMap;
import java.util.Map;

public class IntegerFlip {
    static String flip(int N) {
        long num = 1;
        StringBuilder builder = new StringBuilder();
        builder.append("0.");
        Map<Long, Integer> map = new HashMap<>();
        while (num != 0) {
            num *= 10;
            builder.append(num / N);
            num %= N;
            if (map.containsKey(num)) {
                int index = map.get(num);
                String repeat = builder.substring(index);
                builder.append(" ").append(repeat);
                return builder.toString();
            } else {
                map.put(num, builder.length());
            }
        }
        builder.append("0 0");
        return builder.toString();
    }

    public static void main(String[] args) {
        System.out.println(flip(90));
    }
}

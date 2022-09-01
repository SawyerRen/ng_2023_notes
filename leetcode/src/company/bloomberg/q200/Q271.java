package company.bloomberg.q200;

import java.util.ArrayList;
import java.util.List;

public class Q271 {
    public class Codec {

        // Encodes a list of strings to a single string.
        public String encode(List<String> strs) {
            StringBuilder builder = new StringBuilder();
            for (String str : strs) {
                builder.append(str.length()).append("/").append(str);
            }
            return builder.toString();
        }

        // Decodes a single string to a list of strings.
        public List<String> decode(String s) {
            List<String> res = new ArrayList<>();
            int index = 0;
            while (index < s.length()) {
                int slashIndex = s.indexOf("/", index);
                int size = Integer.parseInt(s.substring(index, slashIndex));
                res.add(s.substring(slashIndex + 1, slashIndex + 1 + size));
                index = slashIndex + size + 1;
            }
            return res;
        }
    }
}

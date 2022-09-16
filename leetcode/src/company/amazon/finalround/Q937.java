package company.amazon.finalround;

import java.util.Arrays;

public class Q937 {
    public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, (a, b) -> {
            String[] split1 = a.split(" ", 2);
            String[] split2 = b.split(" ", 2);
            char c1 = split1[1].charAt(0);
            char c2 = split2[1].charAt(0);
            if (Character.isDigit(c1) && Character.isDigit(c2)) return 0;
            if (Character.isDigit(c1)) return 1;
            if (Character.isDigit(c2)) return -1;
            if (split1[1].equals(split2[1])) return split1[0].compareTo(split2[0]);
            return split1[1].compareTo(split2[1]);
        });
        return logs;
    }
}

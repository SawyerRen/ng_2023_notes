package company.bloomberg.all.other;

import java.util.HashSet;
import java.util.LinkedHashSet;

public class FirstUniqueCharacterInStringStream {
    HashSet<Character> duplicate = new HashSet<>();
    LinkedHashSet<Character> unique = new LinkedHashSet<>();

    public FirstUniqueCharacterInStringStream(char[] chars) {
        for (char c : chars) {
            add(c);
        }
    }

    char showFirstUnique() {
        if (unique.isEmpty()) return ' ';
        for (Character c : unique) {
            return c;
        }
        return ' ';
    }

    private void add(char c) {
        if (!unique.contains(c) && !duplicate.contains(c)) {
            unique.add(c);
        } else {
            if (unique.contains(c)) {
                unique.remove(c);
                duplicate.add(c);
            }
        }
    }
}

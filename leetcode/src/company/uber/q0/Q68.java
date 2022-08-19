package company.uber.q0;

import java.util.ArrayList;
import java.util.List;

public class Q68 {
    public List<String> fullJustify(String[] words, int maxWidth) {
        int left = 0;
        List<String> res = new ArrayList<>();
        while (left < words.length) {
            int right = findRight(words, left, maxWidth);
            res.add(getString(words, left, right, maxWidth));
            left = right + 1;
        }
        return res;
    }

    private String getString(String[] words, int left, int right, int maxWidth) {
        if (left == right) return padRight(words[left], maxWidth);
        int wordLength = 0;
        for (int i = left; i <= right; i++) {
            wordLength += words[i].length();
        }
        boolean lastLine = right == words.length - 1;
        int spaceCount = right - left;
        int spaceLength = lastLine ? 1 : (maxWidth - wordLength) / spaceCount;
        int remainder = lastLine ? 0 : (maxWidth - wordLength) % spaceCount;
        StringBuilder builder = new StringBuilder();
        for (int i = left; i < right; i++) {
            builder.append(words[i]);
            builder.append(getEmptyString(spaceLength));
            builder.append(remainder-- > 0 ? " " : "");
        }
        builder.append(words[right]);
        if (lastLine) return padRight(builder.toString(), maxWidth);
        return builder.toString();
    }

    private String getEmptyString(int spaceLength) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < spaceLength; i++) {
            builder.append(" ");
        }
        return builder.toString();
    }

    private String padRight(String word, int maxWidth) {
        StringBuilder builder = new StringBuilder();
        builder.append(word);
        while (builder.length() < maxWidth) builder.append(" ");
        return builder.toString();
    }

    private int findRight(String[] words, int left, int maxWidth) {
        int right = left;
        int len = words[right++].length();
        while (right < words.length && len + words[right].length() + 1 <= maxWidth) {
            len += words[right++].length() + 1;
        }
        return right - 1;
    }
}

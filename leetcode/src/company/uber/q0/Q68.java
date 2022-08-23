package company.uber.q0;

import java.util.ArrayList;
import java.util.List;

public class Q68 {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        int left = 0, right = 0;
        while (left < words.length) {
            right = findRight(words, left, maxWidth);
            res.add(buildString(words, left, right, maxWidth));
            left = right + 1;
        }
        return res;
    }

    private String buildString(String[] words, int left, int right, int maxWidth) {
        if (left == right) return padRight(words[right], maxWidth);
        boolean isLastLine = right == words.length - 1;
        int wordLen = 0;
        for (int i = left; i < right + 1; i++) {
            wordLen += words[i].length();
        }
        int blankCount = right - left;
        int blankLen = isLastLine ? 1 : (maxWidth - wordLen) / blankCount;
        int remainder = isLastLine ? 0 : (maxWidth - wordLen) % blankCount;
        StringBuilder builder = new StringBuilder();
        for (int i = left; i < right; i++) {
            builder.append(words[i]);
            builder.append(getEmptyString(blankLen));
            builder.append(remainder-- > 0 ? " " : "");
        }
        builder.append(words[right]);
        if (isLastLine) return padRight(builder.toString(), maxWidth);
        return builder.toString();
    }

    private String getEmptyString(int blankLen) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < blankLen; i++) {
            builder.append(" ");
        }
        return builder.toString();
    }

    private String padRight(String word, int maxWidth) {
        StringBuilder builder = new StringBuilder();
        builder.append(word);
        while (builder.length() < maxWidth) {
            builder.append(" ");
        }
        return builder.toString();
    }

    private int findRight(String[] words, int left, int maxWidth) {
        int right = left;
        int sum = words[right++].length();
        while (right < words.length && sum + 1 + words[right].length() <= maxWidth) {
            sum += 1 + words[right++].length();
        }
        return right - 1;
    }
}

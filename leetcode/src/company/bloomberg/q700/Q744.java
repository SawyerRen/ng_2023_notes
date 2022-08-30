package company.bloomberg.q700;

public class Q744 {
    public char nextGreatestLetter(char[] letters, char target) {
        for (char letter : letters) {
            if (letter > target) return letter;
        }
        return letters[0];
    }
}

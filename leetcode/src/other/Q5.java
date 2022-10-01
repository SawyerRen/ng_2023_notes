package other;

public class Q5 {
    static class Node {
        Node[] children = new Node[10];
    }

    static int solution(int[] firstArray, int[] secondArray) {
        Node root = new Node();
        for (int i : firstArray) {
            String s = String.valueOf(i);
            Node cur = root;
            for (char c : s.toCharArray()) {
                int index = c - '0';
                if (cur.children[index] == null) cur.children[index] = new Node();
                cur = cur.children[index];
            }
        }
        int res = 0;
        for (int i : secondArray) {
            String s = String.valueOf(i);
            Node cur = root;
            int len = 0;
            for (char c : s.toCharArray()) {
                if (cur.children[c - '0'] == null) continue;
                len++;
                cur = cur.children[c - '0'];
                res = Math.max(res, len);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] a1 = {25, 288, 2665, 54546, 54, 555};
        int[] a2 = {2, 255, 266, 244, 26, 5, 54547};
        int[] a3 = {25, 288, 2665, 544, 54, 555};
        int[] a4 = {2, 255, 266, 244, 26, 5, 5444444};
        System.out.println(solution(a1, a2));
        System.out.println(solution(a3, a4));
    }
}

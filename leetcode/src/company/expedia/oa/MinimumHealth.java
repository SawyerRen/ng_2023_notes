package company.expedia.oa;

import java.util.PriorityQueue;

public class MinimumHealth {
    static int solution(int[] initialPlayers, int[] newPlayers, int rank) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i : initialPlayers) {
            pq.add(i);
            if (pq.size() > rank) pq.poll();
        }
        int res = pq.peek();
        for (int i : newPlayers) {
            pq.add(i);
            if (pq.size() > rank) pq.poll();
            res += pq.peek();
        }
        return res;
    }

    public static void main(String[] args) {
        int[] init = {1, 2};
        int[] news = {3, 4};
        int rank = 2;
        System.out.println(solution(init, news, rank));
    }
}

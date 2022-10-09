package company.bloomberg.mj.nontag;

public class ThrottlingGateway {
    static int solution(int[] arr) {
        int count = 0;
        boolean[] dropped = new boolean[arr.length];
        for (int i = 0; i < arr.length; i++) {
            if (i >= 3 && arr[i] == arr[i - 3] && !dropped[i - 2]) {
                dropped[i - 2] = true;
                count++;
            }
            if (i >= 20 && arr[i] - arr[i - 20] < 10 && !dropped[i - 20]) {
                dropped[i - 20] = true;
                count++;
            }
            if (i >= 60 && arr[i] - arr[i - 60] < 60 && !dropped[i - 60]) {
                dropped[i - 60] = true;
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 4, 5, 5, 5, 6, 6, 6, 7, 7, 7, 7, 11, 11, 11, 11};
        System.out.println(solution(arr));
    }
}

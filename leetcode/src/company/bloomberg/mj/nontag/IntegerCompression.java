package company.bloomberg.mj.nontag;

public class IntegerCompression {
    static int solution(int num) {
        int temp = 0;
        while (num != 0) {
            int tail = num % 10;
            int count = 0;
            while (num != 0 && num % 10 == tail) {
                count++;
                num /= 10;
            }
            temp = temp * 10 + tail;
            temp = temp * 10 + count;
        }
        int res = 0;
        while (temp != 0) {
            res = res * 10 + temp % 10;
            temp /= 10;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(solution(11122233));
    }
}

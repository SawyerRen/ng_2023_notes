package company.bloomberg.r2;

public class IntegerCompression {
    int solution(int num) {
        int temp = 0;
        while (num != 0) {
            int tail = num % 10;
            int count = 0;
            while (num != 0 && num % 10 == tail) {
                num /= 10;
                count++;
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
}

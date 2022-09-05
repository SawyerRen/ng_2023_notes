package company.uber.q600;

public class Q621 {
    public int leastInterval(char[] tasks, int n) {
        int max = 0, maxCount = 0;
        int[] count = new int[26];
        for (char task : tasks) {
            count[task - 'A']++;
            if (count[task - 'A'] > max) {
                maxCount = 1;
                max = count[task - 'A'];
            } else if (count[task - 'A'] == max) {
                maxCount++;
            }
        }
        int partCount = max - 1;
        int partLen = n + 1 - maxCount;
        int remain = tasks.length - max * maxCount;
        int idle = partCount * partLen - remain;
        if (idle <= 0) return tasks.length;
        return tasks.length + idle;
    }
}

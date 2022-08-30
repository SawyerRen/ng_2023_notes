package company.bloomberg.q800;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Q895 {
    class FreqStack {
        Map<Integer, Integer> freqMap = new HashMap<>();
        Map<Integer, Stack<Integer>> stackMap = new HashMap<>();
        int maxFreq = 0;

        public FreqStack() {

        }

        public void push(int val) {
            Integer freq = freqMap.getOrDefault(val, 0);
            freq++;
            maxFreq = Math.max(maxFreq, freq);
            freqMap.put(val, freq);
            stackMap.putIfAbsent(freq, new Stack<>());
            stackMap.get(freq).add(val);
        }

        public int pop() {
            Stack<Integer> stack = stackMap.get(maxFreq);
            Integer val = stack.pop();
            freqMap.put(val, maxFreq - 1);
            if (stack.isEmpty()) maxFreq--;
            return val;
        }
    }
}

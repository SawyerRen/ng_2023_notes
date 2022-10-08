package company.bloomberg.vo;

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
            maxFreq = Math.max(freq, maxFreq);
            freqMap.put(val, freq);
            stackMap.putIfAbsent(freq, new Stack<>());
            stackMap.get(freq).add(val);
        }

        public int pop() {
            Stack<Integer> stack = stackMap.get(maxFreq);
            Integer val = stack.pop();
            if (stack.isEmpty()) maxFreq--;
            freqMap.put(val, freqMap.get(val) - 1);
            return val;
        }
    }
}

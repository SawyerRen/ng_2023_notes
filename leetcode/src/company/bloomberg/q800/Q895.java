package company.bloomberg.q800;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Q895 {
    class FreqStack {
        Map<Integer, Integer> freqMap = new HashMap<>();
        Map<Integer, Stack<Integer>> stackMap = new HashMap<>();
        int max = 0;

        public FreqStack() {

        }

        public void push(int val) {
            int freq = freqMap.getOrDefault(val, 0);
            freq++;
            freqMap.put(val, freq);
            stackMap.putIfAbsent(freq, new Stack<>());
            max = Math.max(freq, max);
            stackMap.get(freq).add(val);
        }

        public int pop() {
            Stack<Integer> stack = stackMap.get(max);
            Integer val = stack.pop();
            if (stack.isEmpty()) max--;
            freqMap.put(val, freqMap.get(val) - 1);
            return val;
        }
    }
}

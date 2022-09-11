package company.amazon.q100;


import java.util.*;

public class Q126 {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Map<String, Set<String>> map = new HashMap<>();
        Set<String> curSet = new HashSet<>();
        Set<String> wordSet = new HashSet<>(wordList);
        curSet.add(beginWord);
        boolean found = false;
        while (!curSet.isEmpty() && !found) {
            wordSet.removeAll(curSet);
            Set<String> nextSet = new HashSet<>();
            for (String s : curSet) {
                List<String> nextList = getNext(s, wordSet);
                for (String next : nextList) {
                    if (next.equals(endWord)) found = true;
                    nextSet.add(next);
                    map.putIfAbsent(s, new HashSet<>());
                    map.get(s).add(next);
                }
            }
            curSet = nextSet;
        }
        if (!found) return new ArrayList<>();
        List<String> list = new ArrayList<>();
        list.add(beginWord);
        List<List<String>> res = new ArrayList<>();
        helper(res, list, map, beginWord, endWord);
        return res;
    }

    private void helper(List<List<String>> res, List<String> list, Map<String, Set<String>> map, String beginWord, String endWord) {
        if (beginWord.equals(endWord)) {
            res.add(new ArrayList<>(list));
            return;
        }
        if (map.containsKey(beginWord)) {
            for (String next : map.get(beginWord)) {
                list.add(next);
                helper(res, list, map, next, endWord);
                list.remove(list.size() - 1);
            }
        }
    }

    private List<String> getNext(String s, Set<String> wordSet) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            char[] chars = s.toCharArray();
            for (char c = 'a'; c <= 'z'; c++) {
                chars[i] = c;
                String s1 = new String(chars);
                if (wordSet.contains(s1)) list.add(s1);
            }
        }
        return list;
    }
}

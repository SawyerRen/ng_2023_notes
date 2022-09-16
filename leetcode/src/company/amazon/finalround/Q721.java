package company.amazon.finalround;

import java.util.*;

public class Q721 {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        UnionFind uf = new UnionFind(accounts.size());
        Map<String, Integer> mailIndexMap = new HashMap<>();
        for (int i = 0; i < accounts.size(); i++) {
            for (int j = 1; j < accounts.get(i).size(); j++) {
                String mail = accounts.get(i).get(j);
                if (mailIndexMap.containsKey(mail)) {
                    uf.union(mailIndexMap.get(mail), i);
                } else {
                    mailIndexMap.put(mail, i);
                }
            }
        }
        Map<Integer, List<String>> indexMailMap = new HashMap<>();
        for (String mail : mailIndexMap.keySet()) {
            int index = uf.find(mailIndexMap.get(mail));
            indexMailMap.putIfAbsent(index, new ArrayList<>());
            indexMailMap.get(index).add(mail);
        }
        List<List<String>> res = new ArrayList<>();
        for (Integer index : indexMailMap.keySet()) {
            List<String> list = indexMailMap.get(index);
            list.sort((a, b) -> a.compareTo(b));
            list.add(0, accounts.get(index).get(0));
            res.add(list);
        }
        return res;
    }

    class UnionFind {
        int[] parents;

        public UnionFind(int n) {
            parents = new int[n];
            for (int i = 0; i < n; i++) {
                parents[i] = i;
            }
        }

        int find(int i) {
            while (i != parents[i]) {
                parents[i] = parents[parents[i]];
                i = parents[i];
            }
            return i;
        }

        void union(int i, int j) {
            int p1 = find(i), p2 = find(j);
            parents[p2] = p1;
        }
    }
}

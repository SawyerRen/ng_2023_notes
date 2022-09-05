package company.uber.q700;

import java.util.*;

public class Q721 {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, Integer> emailIndexMap = new HashMap<>();
        UnionFind uf = new UnionFind(accounts.size());
        for (int i = 0; i < accounts.size(); i++) {
            for (int j = 1; j < accounts.get(i).size(); j++) {
                String email = accounts.get(i).get(j);
                if (emailIndexMap.containsKey(email)) {
                    uf.union(i, emailIndexMap.get(email));
                } else {
                    emailIndexMap.put(email, i);
                }
            }
        }
        Map<Integer, Set<String>> indexEmailMap = new HashMap<>();
        for (String email : emailIndexMap.keySet()) {
            int index = uf.find(emailIndexMap.get(email));
            indexEmailMap.putIfAbsent(index, new HashSet<>());
            indexEmailMap.get(index).add(email);
        }
        List<List<String>> res = new ArrayList<>();
        for (Integer index : indexEmailMap.keySet()) {
            List<String> list = new ArrayList<>(indexEmailMap.get(index));
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
            for (int i = 0; i < parents.length; i++) {
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

package company.uber.all1;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q721 {
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
            if (p1 == p2) return;
            parents[p2] = p1;
        }
    }

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, Integer> mail2Index = new HashMap<>();
        UnionFind uf = new UnionFind(accounts.size());
        for (int i = 0; i < accounts.size(); i++) {
            for (int j = 1; j < accounts.get(i).size(); j++) {
                String mail = accounts.get(i).get(j);
                if (mail2Index.containsKey(mail)) {
                    uf.union(mail2Index.get(mail), i);
                } else {
                    mail2Index.put(mail, i);
                }
            }
        }
        Map<Integer, List<String>> index2Mail = new HashMap<>();
        for (String mail : mail2Index.keySet()) {
            int index = uf.find(mail2Index.get(mail));
            index2Mail.putIfAbsent(index, new ArrayList<>());
            index2Mail.get(index).add(mail);
        }
        List<List<String>> res = new ArrayList<>();
        for (Integer index : index2Mail.keySet()) {
            List<String> list = index2Mail.get(index);
            list.sort((a, b) -> a.compareTo(b));
            list.add(0, accounts.get(index).get(0));
            res.add(list);
        }
        return res;
    }
}

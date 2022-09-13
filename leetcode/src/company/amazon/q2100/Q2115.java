package company.amazon.q2100;

import java.util.*;

public class Q2115 {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        Map<String, Set<String>> map = new HashMap<>();
        Map<String, Integer> preCount = new HashMap<>();
        Set<String> recipeSet = new HashSet<>();
        for (int i = 0; i < recipes.length; i++) {
            recipeSet.add(recipes[i]);
            for (String in : ingredients.get(i)) {
                map.putIfAbsent(in, new HashSet<>());
                map.get(in).add(recipes[i]);
            }
            preCount.put(recipes[i], ingredients.get(i).size());
        }
        Queue<String> queue = new LinkedList<>(Arrays.asList(supplies));
        List<String> res = new ArrayList<>();
        while (!queue.isEmpty()) {
            String poll = queue.poll();
            if (recipeSet.contains(poll)) res.add(poll);
            if (map.containsKey(poll)) {
                for (String next : map.get(poll)) {
                    preCount.put(next, preCount.get(next) - 1);
                    if (preCount.get(next) == 0) queue.add(next);
                }
            }
        }
        return res;
    }
}

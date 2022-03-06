package com.company;

import java.util.*;

public class Find_All_Possible_Recipes_from_Given_Supplies {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        HashMap<String, Integer> indegree = new HashMap<>();
        HashMap<String,List<String>> ingre2recipes = new HashMap<>();
        HashSet<String> rece = new HashSet<>();

        for(int i = 0;i< recipes.length;i++) {
            List<String> need = ingredients.get(i);
            String r = recipes[i];

            rece.add(r);

            for (String ingre : need) {
                if (!ingre2recipes.containsKey(ingre))
                    ingre2recipes.put(ingre, new ArrayList<>());

                ingre2recipes.get(ingre).add(r);

                indegree.put(r, indegree.getOrDefault(r, 0) + 1);
            }
        }

            Queue<String> queue = new LinkedList<>();
            List<String> result = new ArrayList<>();
            for(String str: supplies)
                queue.add(str);

            while(!queue.isEmpty())
            {
                String cur = queue.poll();
                if(rece.contains(cur))
                {
                    result.add(cur);
                }

                if(ingre2recipes.containsKey(cur))
                {
                    List<String> cur_to_do = ingre2recipes.get(cur);
                    for(String to_do :cur_to_do)
                    {
                        int new_indegre = indegree.get(to_do)-1;
                        indegree.put(to_do, new_indegre);
                        if(new_indegre == 0)
                        {
                            queue.add(to_do);
                        }
                    }
                }

            }
         return result;
    }


}

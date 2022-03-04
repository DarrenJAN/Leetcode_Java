package com.company;

import java.util.*;

public class Accounts_Merge {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        HashMap<String, Integer> hashMap = new HashMap<>();
        int size = accounts.size();

        UnionFind union = new UnionFind(size);

        for (int i = 0; i < size; i++) {
            List<String> cur_list = accounts.get(i);

            for (int j = 1; j < cur_list.size(); j++) {
                String email = cur_list.get(j);
                if (!hashMap.containsKey(email)) {
                    hashMap.put(email, i);
                } else {
                    union.union(i, hashMap.get(email));
                }
            }
        }

        HashMap<Integer, List<String>> components = new HashMap<Integer, List<String>>();
        for (String email : hashMap.keySet()) {
            int group = hashMap.get(email);
            int parent = union.find(group);

            if (!components.containsKey(parent)) {
                components.put(parent, new ArrayList<String>());
            }

            components.get(parent).add(email);

        }

        List<List<String>> mergedAccounts = new ArrayList<>();
        for (int group : components.keySet()) {
            List<String> component = components.get(group);
            Collections.sort(component);
            component.add(0, accounts.get(group).get(0));
            mergedAccounts.add(component);
        }

        return mergedAccounts;
    }

    class UnionFind {
        int[] parent;
        int[] rank;

        UnionFind(int size) {
            parent = new int[size];
            rank = new int[size];

            for (int i = 0; i < size; i++) {
                parent[i] = i;
                rank[i] = 1;
            }
        }

        int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        boolean union(int x, int y) {
            int parent_x = find(x);
            int parent_y = find(y);

            if (parent_x == parent_y) {
                return false;
            }

            if (rank[parent_x] > rank[parent_y]) {
                parent[parent_y] = parent_x;
            } else if (rank[x] < rank[parent_y]) {
                parent[parent_x] = parent_y;
            } else {
                parent[parent_x] = parent_y;
                rank[parent_y]++;
            }
            return true;
        }
    }
}

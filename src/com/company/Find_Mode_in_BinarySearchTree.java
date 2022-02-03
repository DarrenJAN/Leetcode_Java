package com.company;

import java.util.*;

public class Find_Mode_in_BinarySearchTree {
    HashMap<Integer , Integer> hashMap= new HashMap<>();

    public int[] findMode(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        dfs(root);
        int max =0;
        for(Map.Entry<Integer, Integer> entry : hashMap.entrySet())
        {
            if(max < entry.getValue())
            {
                max = entry.getValue();
               result.clear();
               result.add(entry.getKey());
            }else if(max == entry.getValue())
                result.add(entry.getKey());
        }

        int[] re = new int[result.size()];
        for(int i = 0 ; i< result.size(); i++)
            re[i] = result.get(i);
        return re;
    }

    public void dfs(TreeNode root)
    {
        if(root == null)
            return;

        hashMap.put(root.val, hashMap.getOrDefault(root.val, 0) +1);
        dfs(root.left);
        dfs(root.right);
    }
}

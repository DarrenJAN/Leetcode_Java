package com.company;

import java.util.*;

public class Most_Frequent_Subtree_Sum {
    HashMap<Integer, Integer> hashMap = new HashMap<>();
    public int[] findFrequentTreeSum(TreeNode root) {
        dfs(root);

        int freq = 0;
        List<Integer> result = new ArrayList<>();
        for(Map.Entry entry : hashMap.entrySet())
        {
            int key = (int)entry.getKey();
            int val =(int)entry.getValue();
            if(val > freq) {
                freq = val;
                result.clear();
                result.add(key);
            } else if(val == freq)
            {
                result.add(key);
            }
        }

        int[] r = new int[result.size()];
        for(int i = 0;i<result.size();i++)
            r[i] = result.get(i);
        return r;
    }

    public int SubtreeSum(TreeNode root)
    {
        if(root == null)
        {
            return 0;
        } else
        {
            return root.val + SubtreeSum(root.left) + SubtreeSum(root.right);
        }
    }

    public void dfs(TreeNode root)
    {
        int sum = SubtreeSum(root);
        hashMap.put(sum, hashMap.getOrDefault(sum, 0) +1);
        if(root.left != null)
            dfs(root.left);
        if(root.right  != null)
            dfs(root.right);
    }
}

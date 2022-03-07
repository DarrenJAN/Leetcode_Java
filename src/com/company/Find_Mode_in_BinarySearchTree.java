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

    //no extra space

        Integer pre = null;
        int count =1;
     int max_num = 1;
        List<Integer> mode = new ArrayList<>();

        public int[] findMode_2(TreeNode root) {
            pre_order(root);
            int[] result =new int[mode.size()];

            for(int i =0;i<result.length;i++)
            {
                result[i] = mode.get(i);
            }
            return result;
        }

        public void pre_order(TreeNode root)
        {
            if(root == null)
            {
                return;
            }

            pre_order(root.left);

            if(pre != null)
            {
                if(pre ==root.val)
                {
                    count ++;

                }else
                {
                    count = 1;
                }
            }

            if(count > max_num)
            {
                mode.clear();
                mode.add(root.val);
                max_num = count;
            }else  if( count == max_num)
            {
                mode.add(root.val);
            }

            pre = root.val;

            pre_order(root.right);
        }
}

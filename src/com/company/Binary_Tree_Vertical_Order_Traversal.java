package com.company;

import java.util.*;

public class Binary_Tree_Vertical_Order_Traversal {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null)
            return result;

        Queue<Pair> queue = new LinkedList<>();
        HashMap<Integer, List<Integer>> hashMap = new HashMap<>();

        queue.add(new Pair(root, 0));
        while(! queue.isEmpty())
        {
            int size = queue.size();
            for(int i = 0;i<size;i++)
            {
                Pair cur = queue.poll();
                TreeNode cur_node = cur.node;
                int cur_col = cur.col;

                if(!hashMap.containsKey(cur_col))
                {
                    hashMap.put(cur_col, new ArrayList<>());
                }
                hashMap.get(cur_col).add(cur_node.val);

                if(cur_node.left != null)
                    queue.add(new Pair(cur_node.left, cur_col-1));
                if(cur_node.right != null)
                    queue.add(new Pair(cur_node.right, cur_col+1));
            }
        }

        List<Integer> keyset = new ArrayList<>(hashMap.keySet());
        Collections.sort(keyset);
        for(int k: keyset)
        {
            result.add(hashMap.get(k));
        }
        return result;
    }

    class Pair{
        TreeNode node;
        int col;

        Pair(TreeNode node, int col)
        {
            this.node = node;
            this.col = col;
        }
    }
}

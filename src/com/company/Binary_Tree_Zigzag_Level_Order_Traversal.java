package com.company;

import java.util.*;

public class Binary_Tree_Zigzag_Level_Order_Traversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if(root == null)
            return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        Boolean left = true;
        while(! queue.isEmpty())
        {
            List<Integer> cur = new ArrayList<>();

            int size = queue.size();
            for(int i = 0;i<size;i++)
            {
                TreeNode cur_node = queue.poll();
                cur.add(cur_node.val);
                if(cur_node.left != null)
                    queue.add(cur_node.left);
                if(cur_node.right != null)
                    queue.add(cur_node.right);

            }

            if(left == true)
                left = false;
            else
            {
                Collections.reverse(cur);
                left = true;
            }
            result.add(cur);
        }
        return result;
    }
}

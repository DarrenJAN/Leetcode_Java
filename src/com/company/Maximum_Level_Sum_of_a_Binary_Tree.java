package com.company;

import java.util.LinkedList;
import java.util.Queue;

public class Maximum_Level_Sum_of_a_Binary_Tree {
    public int maxLevelSum(TreeNode root) {
        int result = Integer.MIN_VALUE;
        int result_level = 0;
        if(root == null)
            return 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level = 0;

        while( ! queue.isEmpty())
        {
            level++;
            int size = queue.size();
            int cur_sum = 0;
            for(int i =0;i<size;i++)
            {
                TreeNode cur_node = queue.poll();
                cur_sum += cur_node.val;

                if(cur_node.left != null)
                    queue.add(cur_node.left);

                if(cur_node.right != null)
                    queue.add(cur_node.right);
            }
            if(cur_sum > result)
            {
                result = cur_sum;
                result_level =level;
            }
        }

        return result_level;

    }
}

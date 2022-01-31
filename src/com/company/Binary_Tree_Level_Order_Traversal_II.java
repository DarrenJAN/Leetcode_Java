package com.company;

import java.util.*;

public class Binary_Tree_Level_Order_Traversal_II {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null)
            return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while( ! queue.isEmpty())
        {
            int size = queue.size();
            List<Integer> tmp =  new ArrayList<>();

            for(int i =0; i<size;i++)
            {
                TreeNode cur_node = queue.poll();
                tmp.add(cur_node.val);

                if(cur_node.left != null)
                    queue.add(cur_node.left);
                if(cur_node.right != null)
                    queue.add(cur_node.right);

            }
            result.add(tmp);
        }

        Collections.reverse(result);
        return result;
    }
}

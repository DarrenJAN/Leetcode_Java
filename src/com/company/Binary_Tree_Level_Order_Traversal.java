package com.company;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Binary_Tree_Level_Order_Traversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        if(root == null)
            return result;

        queue.add(root);

        while(!queue.isEmpty())
        {
            int size = queue.size();
            List<Integer> cur_level = new LinkedList<>();
            for(int i = 0 ;i< size;i++)
            {
                TreeNode cur_treenode = queue.poll();
                cur_level.add(cur_treenode.val);
                if(cur_treenode.left != null)
                    queue.add(cur_treenode.left);
                if(cur_treenode.right != null)
                    queue.add(cur_treenode.right);


            }
            result.add(cur_level);
        }

        return result;
    }


}

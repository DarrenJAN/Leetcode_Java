package com.company;

import java.util.LinkedList;
import java.util.Queue;

public class Find_Bottom_Left_Tree_Value {
    public int findBottomLeftValue(TreeNode root) {
        if(root == null)
            return -1;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        TreeNode left = root;
        while(! queue.isEmpty())
        {
            int size = queue.size();
            left = queue.peek();
            for(int i =0;i<size;i++)
            {
                TreeNode cur = queue.poll();
                if(cur.left != null)
                    queue.add(cur.left);

                if(cur.right != null)
                    queue.add(cur.right);
            }
        }
        return left.val;
    }


    int result = 0;
    int max_depth = -1;
    public int findBottomLeftValue_2(TreeNode root) {
        depth(root, 0);
        return result;
    }

    public void depth(TreeNode root, int cur_depth)
    {
        if(root == null)
        {
            return;
        }

        if(cur_depth > max_depth )
        {
            max_depth = cur_depth;
            result = root.val;
        }

        depth(root.left, cur_depth+1);
        depth(root.right, cur_depth+1);
    }

}

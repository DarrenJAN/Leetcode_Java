package com.company;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Binary_Tree_Right_Side_View {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer>  result = new ArrayList<>();

        if(root == null)
        {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(! queue.isEmpty())
        {
            int size = queue.size();
            for(int i = 0 ;i< size;i++)
            {
                TreeNode cur = queue.poll();
                if(i == 0)
                {
                    result.add(cur.val);
                }

                if(cur.right != null)
                    queue.add(cur.right);
                if(cur.left != null)
                    queue.add(cur.left);
            }
        }

        return result;

    }
}

package com.company;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class N_ary_Tree_Level_Order_Traversal {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null)
        {
            return result;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty())
        {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for(int i = 0 ;i< size;i++)
            {
                Node cur_node = queue.poll();
                list.add(cur_node.val);

                List<Node> children = cur_node.children;
                for(int j = 0 ; j< children.size();j++)
                {
                    queue.add(children.get(j));
                }
            }
            result.add(list);

        }

        return result;
    }


}

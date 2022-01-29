package com.company;

import java.util.ArrayList;
import java.util.List;

public class N_ary_Tree_Postorder_Traversal {
    public List<Integer> postorder(Node root) {
         List<Integer> result = new ArrayList<>();
         post_order_helper(root, result);
         return result;

    }

    public void post_order_helper(Node root, List<Integer> result)
    {
        if( root == null)
            return;

        List<Node> children = root.children;

        for(int i = 0;i<children.size();i++)
        {
            post_order_helper(children.get(i), result);
        }
        result.add(root.val);
    }
}

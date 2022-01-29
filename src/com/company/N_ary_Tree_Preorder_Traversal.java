package com.company;

import java.util.ArrayList;
import java.util.List;

public class N_ary_Tree_Preorder_Traversal {
    public List<Integer> preorder(Node root) {
        List<Integer> result = new ArrayList<>();

        pre_order_helper(root, result);
        return result;

    }

    public void pre_order_helper(Node root, List<Integer> reuslt)
    {
        if(root == null)
            return;

        reuslt.add(root.val);
        List<Node> children = root.children;

        for(int i = 0; i<children.size();i++)
        {
            pre_order_helper(children.get(i), reuslt);
        }
    }

}

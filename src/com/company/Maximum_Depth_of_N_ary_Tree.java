package com.company;

import java.util.List;

public class Maximum_Depth_of_N_ary_Tree {
    int result = 0;
    public int maxDepth(Node root) {
        maxDepth_helper(root,0);
        return result;
    }

    public void maxDepth_helper(Node root, int depth) {
        if(root == null)
            return;

        List<Node> childrens = root.children;
        result = Math.max(result, depth+1);
        for(Node c : childrens)
        {
            maxDepth_helper(c, depth+1);
        }
    }
}
